package com.E_books.rental.serviceImpl;

import com.E_books.rental.AdminService;
import com.E_books.rental.dto.AdminDto;
import com.E_books.rental.mapper.AdminMapper;
import com.E_books.rental.model.Admin;
import com.E_books.rental.repository.AdminRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto){
        Admin admin = AdminMapper.mapToAdmin(adminDto);
        Admin savedAdmin = adminRepository.save(admin);
        return AdminMapper.mapToadminDto(savedAdmin);
    }

    @Override
    public List<AdminDto> getAllAdmins(){
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
         .map(AdminMapper::mapToadminDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdminDto getAdminById(int adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin does not exist"));
        return AdminMapper.mapToadminDto(admin);
    }

    @Override
    public AdminDto updateAdmin(int adminId, AdminDto adminDto){
        Admin existingAdmin = adminRepository.findById(adminId)
                .orElseThrow(()-> new RuntimeException("admin doesnt exist"));

        if(adminDto.getName() !=null){
            existingAdmin.setName(adminDto.getName());
        }
        existingAdmin.setName(adminDto.getName());

        Admin updateAdmin = adminRepository.save(existingAdmin);
        return new AdminDto(updateAdmin.getAdminId(), updateAdmin.getPhoneNo(), updateAdmin.getName(), updateAdmin.getEmail(), updateAdmin.getPassword());
    }
    @Override
    public AdminDto deleteAdminById(int adminId){
        Admin admin = adminRepository.findById(adminId).orElseThrow(()-> new RuntimeException("admin doesnt exist"));

        AdminDto adminDto = AdminMapper.mapToadminDto(admin);
        adminRepository.deleteById(adminId);

        return adminDto;
    }

}
