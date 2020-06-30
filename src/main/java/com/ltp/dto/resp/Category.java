package com.ltp.dto.resp;

import lombok.Data;

/**
 * @author Ltp
 * @description
 * @date 2020/6/30 18:54
 */
@Data
public class Category {
    private Integer categoryId;
    private String categoryName;
    private String userId;
    private Integer rank;
}
