package br.com.stapassoli.crud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {

    @JsonProperty(value = "name")
    @NotBlank(message = "O campo nome deve estar preenchido")
    private String name;

    @JsonProperty(value = "email")
    @Email(message = "Campo email deve estar preenchido e com valor válido")
    private String email;

    @JsonIgnore(value = true)
    private LocalDateTime createAt = LocalDateTime.now();

}
