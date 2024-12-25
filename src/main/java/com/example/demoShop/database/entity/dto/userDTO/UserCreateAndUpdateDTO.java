package com.example.demoShop.database.entity.dto.userDTO;

import com.example.demoShop.database.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateAndUpdateDTO {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private String city;

    private List<Order> orders;
}
