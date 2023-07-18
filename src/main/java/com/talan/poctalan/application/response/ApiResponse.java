package com.talan.poctalan.application.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {

    private Boolean success;
    private String message;
    private T content;

    public ApiResponse(Boolean success, String message, T content){
        this.success = success;
        this.message = message;
        this.content = content;
    }

    public ApiResponse(Boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, T content){
        this.success = success;
        this.message = "SUCCESS";
        this.content = content;
    }

}
