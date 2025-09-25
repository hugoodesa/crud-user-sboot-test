package br.com.stapassoli.crud.dto;

import br.com.stapassoli.crud.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(hidden = true)
    private LocalDateTime createAt = LocalDateTime.now();

    public UserEntity updateEntity(UserEntity entity) {
        entity.setName(this.name);
        entity.setEmail(this.email);
        return entity;
    }

}
