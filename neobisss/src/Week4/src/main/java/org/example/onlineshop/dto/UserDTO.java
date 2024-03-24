package org.example.onlineshop.dto;
import  lombok.Data;
@Data
public class UserDTO {
    private Long Id;
    private String name;
    private String surname;
    private String password;
    private String email;
}
