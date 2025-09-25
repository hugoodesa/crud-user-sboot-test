package br.com.stapassoli.crud.service;

import br.com.stapassoli.crud.dto.UserRequestDTO;
import br.com.stapassoli.crud.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseDTO save(UserRequestDTO requestDTO);
    UserResponseDTO findById(Long id);
    UserResponseDTO update(Long id, UserRequestDTO requestDTO);
    void delete(Long id);
    Page<UserResponseDTO> findAll(Pageable pageable);
}
