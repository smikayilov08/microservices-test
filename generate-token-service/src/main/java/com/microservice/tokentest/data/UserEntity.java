package com.microservice.tokentest.data;

import com.microservice.tokentest.model.UserEntityDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "client")
public class UserEntity {
    @Id
    @SequenceGenerator(name = "users_id",sequenceName = "users_id_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="users_id")
    private Integer id;
    private String userName;
    private String password;
    private String role;

    public UserEntity(UserEntityDto dto){
        this.userName=dto.getUserName();
        this.password=dto.getPassword();
        this.role=dto.getRole();
    }
}
