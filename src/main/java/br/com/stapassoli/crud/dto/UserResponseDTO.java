package br.com.stapassoli.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDTO {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "nome")
    private String name;

    @JsonProperty(value = "email")

    private String email;

    @JsonProperty(value = "dataCriacao")
    private LocalDateTime createAt;

}
