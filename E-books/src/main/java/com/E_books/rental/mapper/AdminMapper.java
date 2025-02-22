package com.E_books.rental.mapper;
import com.E_books.rental.dto.AdminDto;
import com.E_books.rental.model.Admin;

public class AdminMapper {

    public static Admin mapToAdmin(AdminDto adminDto){
       Admin admin  = new Admin(
                adminDto.getAdminId(),
                adminDto.getPhoneNo(),
                adminDto.getName(),
                adminDto.getEmail(),
                adminDto.getPassword()

        );
     return admin;
    }

    public static AdminDto mapToadminDto(Admin admin){
        AdminDto adminDto = new AdminDto(
                admin.getAdminId(),
                admin.getPhoneNo(),
                admin.getName(),
                admin.getEmail(),
                admin.getPassword()
        );
        return adminDto;
    }

}
