package br.com.stapassoli.crud.service;

import br.com.stapassoli.crud.dto.UserRequestDTO;
import br.com.stapassoli.crud.dto.UserResponseDTO;
import br.com.stapassoli.crud.entity.UserEntity;
import br.com.stapassoli.crud.exeption.BusinessException;
import br.com.stapassoli.crud.mapper.UserMapper;
import br.com.stapassoli.crud.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    private UserEntity findUserById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }

    private void validateEmail(String email) {
        Optional<UserEntity> user = this.repository.findByEmail(email);

        if(user.isEmpty()) {
            return;
        }

        throw new BusinessException("Email já cadastrado");
    }

    @Override
    public UserResponseDTO save(UserRequestDTO requestDTO) {
        validateEmail(requestDTO.getEmail());
        var requestEntity = mapper.toEntity(requestDTO);
        var entity = repository.save(requestEntity);
        return mapper.toResponseDTO(entity);
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return mapper.toResponseDTO(findUserById(id));
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO requestDTO) {
        validateEmail(requestDTO.getEmail());
        UserEntity user = this.findUserById(id);
        user = this.repository.save(requestDTO.updateEntity(user));
        return mapper.toResponseDTO(user);
    }

    @Override
    public void delete(Long id) {
        this.findUserById(id);
        this.repository.deleteById(id);
    }

    @Override
    public Page<UserResponseDTO> findAll(Pageable pageable) {
        return this.repository.findAllUsers(pageable);
    }

}
