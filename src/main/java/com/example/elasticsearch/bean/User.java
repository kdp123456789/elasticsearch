package com.example.elasticsearch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String sex;
    private String desc;
}
