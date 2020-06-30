package com.ltp.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@DynamicUpdate
@Table(name = "t_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(20) COMMENT '用户名'")
    private String username;
    @Column(columnDefinition = "varchar(20) COMMENT '密码'")
    private String password;
    @Column(columnDefinition = "varchar(20) COMMENT '昵称'")
    private String nickName;
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private LocalDateTime createTime;
}
