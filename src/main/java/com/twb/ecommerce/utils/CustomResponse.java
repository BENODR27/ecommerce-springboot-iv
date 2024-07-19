package com.twb.ecommerce.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class CustomResponse<T> {
    private String status;
    private String message;
    private T data;

}
