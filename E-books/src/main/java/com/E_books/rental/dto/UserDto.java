package com.E_books.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int UserId;

    private String Name;

    private Long PhoneNo;

    private String Email;

    private String Password;


}
