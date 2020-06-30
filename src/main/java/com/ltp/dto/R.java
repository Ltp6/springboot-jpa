package com.ltp.dto;

import lombok.Data;

/**
 * @author Ltp
 * @description
 * @date 2020/6/30 16:32
 */
@Data
public class R<T> {
    private Integer code;
    private String status;
    private String message;
    private T data;
}
