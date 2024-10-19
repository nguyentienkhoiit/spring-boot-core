package com.khoinguyen.core.dto.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.khoinguyen.core.util.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import static com.khoinguyen.core.util.Gender.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto implements Serializable {
    @NotBlank(message = "firstname is not blank")
    private String firstname;

    @NotBlank(message = "lastname is not blank")
    private String lastname;

    @Email(message = "email is not format")
    private String email;

    @PhoneNumber
    private String phone;

    @NotNull(message = "Date of birth must be not null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "Permission is not empty")
    private List<String> permissions;

    @GenderSubset(anyOf = {MALE, FEMALE, OTHER})
    private Gender gender;
}
