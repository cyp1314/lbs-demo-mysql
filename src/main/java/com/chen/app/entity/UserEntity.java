package com.chen.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
    private long id;
    private String name;

    private Double longitude;
    private Double latitude;

    private Date createTime;
}
