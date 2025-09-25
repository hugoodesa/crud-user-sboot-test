package br.com.stapassoli.crud.repository;

import br.com.stapassoli.crud.dto.UserResponseDTO;
import br.com.stapassoli.crud.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    @Query(value = "SELECT new br.com.stapassoli.crud.dto.UserResponseDTO(u.id, u.name, u.email) FROM UserEntity u")
    Page<UserResponseDTO> findAllUsers(Pageable pageable);
}
