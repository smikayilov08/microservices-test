package com.microservice.tokentest.model;

import com.microservice.tokentest.data.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntityDto {
     String userName;
     String password;


     public UserEntityDto(UserEntity userEntity){
          this.userName= userEntity.getUserName();
          this.password= userEntity.getPassword();
     }
}
