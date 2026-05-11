package com.user.mapper;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;
import com.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // DTO → Entity
    @Mapping(target ="name" , expression = "concatFirstAndLastName(request)")
    @Mapping(target= "hashedPassword", source="password", qualifiedByName = "encodePassword")
    User toEntity(UserRequest request);

    // Entity → Response DTO
    UserResponse toResponse(User user);

    default String concatFirstAndLastName(UserRequest request){
        if(!request.getFirstName().isBlank()){
            if(!request.getLastName().isBlank()){
                return request.getFirstName()+" "+request.getLastName();
            }
            return request.getFirstName();
        }
        return null;
    }


}
