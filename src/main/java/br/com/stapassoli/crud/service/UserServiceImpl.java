package br.com.stapassoli.crud.service;

import br.com.stapassoli.crud.dto.UserRequestDTO;
import br.com.stapassoli.crud.dto.UserResponseDTO;
import br.com.stapassoli.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    //private final UserMapper mapper;

    @Override
    public UserResponseDTO save(UserRequestDTO requestDTO) {
        return null;
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public UserResponseDTO update(Long id, UserResponseDTO requestDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
