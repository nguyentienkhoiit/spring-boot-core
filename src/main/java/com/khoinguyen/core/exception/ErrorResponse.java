package com.khoinguyen.core.exception;

import java.util.Date;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String error;
    private String message;
    private int status;
    private String path;
    private Date timestamp;
}
