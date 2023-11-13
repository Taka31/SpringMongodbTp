package com.example.mongodb.exo.mongodbexo.utils;

import com.example.mongodb.exo.mongodbexo.dto.UserDto;
import com.example.mongodb.exo.mongodbexo.model.User;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static UserDto userToUserDto(User user){
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    public static User userDtoToUser(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }
}
