package com.ltp.dto.resp;

import lombok.Data;

/**
 * @author Ltp
 * @description
 * @date 2020/6/30 16:33
 */

@Data
public class UserInfo {
    private String userId;
    private String email;
    private Long maxChannels;
    private Long totalChannels;
    private Long availableChannels;
}
