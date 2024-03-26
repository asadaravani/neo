package org.example.onlineshop.dto;
import  lombok.Data;
import org.example.onlineshop.entity.Role;

@Data
public class UserDTO {
    private String name;
    private String surname;
    private String password;
    private String email;
}
