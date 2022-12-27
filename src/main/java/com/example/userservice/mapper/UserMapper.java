package com.example.userservice.mapper;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(target = "id" ,ignore = true)
    User toEntity(UserDto dto);

}
