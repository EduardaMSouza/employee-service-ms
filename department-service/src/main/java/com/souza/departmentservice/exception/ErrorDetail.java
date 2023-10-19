package com.souza.departmentservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetail {

    private LocalDateTime timestamp;
    private String status;
    private String error;
    private String path;

}
