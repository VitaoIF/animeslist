package com.animeslist.animeslist.mapper;

import com.animeslist.animeslist.dto.request.UserRequest;
import com.animeslist.animeslist.dto.response.UserResponse;
import com.animeslist.animeslist.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request){
        return User.builder().
                email(request.email())
                .name(request.name())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
