package com.E_books.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

    private int adminId;

    private Long phoneNo;

    private String name;

    private String email;

    private String password;




}
