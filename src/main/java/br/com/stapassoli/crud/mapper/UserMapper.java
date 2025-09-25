package br.com.stapassoli.crud.mapper;

import br.com.stapassoli.crud.dto.UserRequestDTO;
import br.com.stapassoli.crud.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", source = "createAt")
    UserEntity toEntity(UserRequestDTO dto);

    @Mapping(target = "createAt", source = "createAt")
    UserRequestDTO toDTO(UserEntity entity);

}
