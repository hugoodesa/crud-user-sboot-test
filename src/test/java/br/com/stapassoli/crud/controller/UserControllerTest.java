package br.com.stapassoli.crud.controller;

import br.com.stapassoli.crud.dto.UserRequestDTO;
import br.com.stapassoli.crud.entity.UserEntity;
import br.com.stapassoli.crud.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    private UserRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();

        requestDTO = new UserRequestDTO();
        requestDTO.setName("Hugo");
        requestDTO.setEmail("hugo@email.com");
        requestDTO.setCreateAt(LocalDateTime.now());
    }

    @Test
    void testCreateUser() throws Exception {
        mockMvc.perform(post("/v1/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Hugo"))
                .andExpect(jsonPath("$.email").value("hugo@email.com"));
    }

    @Test
    void testGetUserById() throws Exception {
        UserEntity savedUser = userRepository.save(new UserEntity(null, "Hugo", "hugodesa@gmail.com", LocalDateTime.now()));

        mockMvc.perform(get("/v1/api/users/" + savedUser.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Hugo"))
                .andExpect(jsonPath("$.email").value("hugodesa@gmail.com"));
    }

    @Test
    void testDeleteUser() throws Exception {
        UserEntity savedUser = userRepository.save(new UserEntity(null, "Hugo", "hugodesa@gmail.com", LocalDateTime.now()));

        mockMvc.perform(delete("/v1/api/users/" + savedUser.getId()))
                .andExpect(status().isNoContent());
    }

}