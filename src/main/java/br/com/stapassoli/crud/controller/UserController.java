package br.com.stapassoli.crud.controller;

import br.com.stapassoli.crud.dto.UserRequestDTO;
import br.com.stapassoli.crud.dto.UserResponseDTO;
import br.com.stapassoli.crud.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO requestDTO) {
        log.info("Creating a new user");
        return ResponseEntity.ok(userService.save(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        log.info("Fetching user with id: {}", id);
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.info("Deleting user with id: {}", id);
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserResponseDTO requestDTO
    ) {
        log.info("Updating user with id: {}", id);
        return ResponseEntity.ok(userService.update(id, requestDTO));
    }

}
