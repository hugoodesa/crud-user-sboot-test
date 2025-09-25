package br.com.stapassoli.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    public UserResponseDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "nome")
    private String name;

    @JsonProperty(value = "email")

    private String email;

    @JsonProperty(value = "dataCriacao")
    private LocalDateTime createAt;

}
