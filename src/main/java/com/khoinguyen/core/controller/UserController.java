package com.khoinguyen.core.controller;

import com.khoinguyen.core.dto.response.ResponseSuccess;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.khoinguyen.core.dto.request.UserRequestDto;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @PostMapping("/")
    public ResponseSuccess addUser(@RequestBody @Valid UserRequestDto requestDto) {
        return new ResponseSuccess(HttpStatus.CREATED, "User added successfully", 1);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseSuccess updateUser(@PathVariable int id, @RequestBody UserRequestDto requestDto) {
        return new ResponseSuccess(HttpStatus.CREATED, "User updated successfully");
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String changeStatus(@PathVariable int id, @RequestParam boolean status) {
        return "User changed "+status+" with user id: "+id;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUser(@PathVariable @Min(1) int id) {
        return "delete user with id = "+id;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getUserById(@PathVariable int id) {
        return "Get user with id: "+ id;
    }
    

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getALlUsers() {
        return ResponseEntity.ok("success");
    }
}
