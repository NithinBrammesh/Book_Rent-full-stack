package com.E_books.rental.controller;

import com.E_books.rental.AdminService;
import com.E_books.rental.dto.AdminDto;
import com.E_books.rental.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    public AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins(){
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @PostMapping
    public ResponseEntity<AdminDto> AddAdmin(@RequestBody AdminDto adminDto){
        return new ResponseEntity<>(adminService.createAdmin(adminDto), HttpStatus.CREATED);
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<AdminDto> getAdminById(int adminId){
        AdminDto adminDto = adminService.getAdminById(adminId);
        return ResponseEntity.ok(adminDto);
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable int adminId, @RequestBody AdminDto adminDto){
        AdminDto updateAdmin = adminService.updateAdmin(adminId, adminDto);
        return ResponseEntity.ok(updateAdmin);
    }
    @DeleteMapping("/{adminId}")
    public ResponseEntity<AdminDto> deleteAdminById(@PathVariable("adminId") int adminId){
        AdminDto deleteAdminById = adminService.deleteAdminById(adminId);
        return ResponseEntity.ok(deleteAdminById);
    }
}
