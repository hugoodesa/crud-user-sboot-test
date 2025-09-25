package br.com.stapassoli.crud.service;

import br.com.stapassoli.crud.dto.UserRequestDTO;
import br.com.stapassoli.crud.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO save(UserRequestDTO requestDTO);
    UserResponseDTO findById(Long id);
    UserResponseDTO update(Long id, UserResponseDTO requestDTO);
    void delete(Long id);

}
