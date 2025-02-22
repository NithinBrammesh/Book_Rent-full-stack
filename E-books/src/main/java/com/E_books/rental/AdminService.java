package com.E_books.rental;

import com.E_books.rental.dto.AdminDto;


import java.util.List;

public interface AdminService {
    AdminDto createAdmin(AdminDto adminDto);

    List<AdminDto> getAllAdmins();

    AdminDto getAdminById(int adminId);

    AdminDto updateAdmin(int adminId, AdminDto adminDto);

    AdminDto deleteAdminById(int adminId);
}
