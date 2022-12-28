package com.example.addressbookappspringboot.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    @NotBlank(message = "Please enter proper firstName ")
    @Pattern(regexp="^[A-Z][a-z A-Z]{2,}$")
    private String firstName;
    @NotBlank(message = "Please enter proper LastName")
    @Pattern(regexp="^[A-Z][a-z A-Z]{2,}$")
    private String lastName;
    @NotBlank(message = "address cannot be empty")
    private String address;
    @NotBlank(message = "city cannot be empty")
    private String city;
    @NotBlank(message = "state cannot be empty")
    private String state;
<<<<<<< HEAD

=======
>>>>>>> 6e81e44858f85de7fd13cde4e0a35125d5d0eb94
    @Pattern(regexp= "^[0-9]{6}(?:-[0-9]{4})?$")
    private String zip;
    @NotBlank(message = "please enter proper mobile number")
    @Pattern(regexp ="^(91){1}[ ]+[0-9]{10}$")
    private String phone;
    @Email(message = "invalid Email Id")
    private String email;


}
