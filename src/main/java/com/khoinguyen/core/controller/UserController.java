package com.khoinguyen.core.controller;

import com.khoinguyen.core.dto.response.ResponseData;
import com.khoinguyen.core.dto.response.ResponseError;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.khoinguyen.core.dto.request.UserRequestDto;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public ResponseData<Integer> addUser(@RequestBody @Valid UserRequestDto requestDto) {
        return ResponseData.<Integer>builder()
                .status(HttpStatus.CREATED.value())
                .message("User added successfully")
                .data(1)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseData<?> updateUser(@PathVariable @Min(1) int id, @RequestBody UserRequestDto requestDto) {
        return ResponseData.<Void>builder()
                .status(HttpStatus.ACCEPTED.value())
                .message("User updated successfully")
                .build();
    }

    @PatchMapping("/{id}")
    public ResponseData<?> changeStatus(@PathVariable int id, @RequestParam boolean status) {
        return ResponseData.<Void>builder()
                .status(HttpStatus.ACCEPTED.value())
                .message("User changed " + status + " with user id: " + id)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseData<?> deleteUser(@PathVariable @Min(1) int id) {
        if(id == 1) {
            return ResponseError.<Void>builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("User not found")
                    .build();
        }
        return ResponseData.<Void>builder()
                .status(HttpStatus.NO_CONTENT.value())
                .message("delete user with id = " + id)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseData<?> getUserById(@PathVariable int id) {
        return ResponseData.<String>builder()
                .status(HttpStatus.OK.value())
                .message("Get successfully")
                .data("Get user with id: " + id)
                .build();
    }


    @GetMapping("/list")
    public ResponseData<?> getALlUsers() {
        return ResponseData.<String>builder()
                .status(HttpStatus.OK.value())
                .message("Get successfully")
                .data("Get all user")
                .build();
    }
}
