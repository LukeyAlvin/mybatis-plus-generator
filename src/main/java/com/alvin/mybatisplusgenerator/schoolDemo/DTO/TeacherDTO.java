package com.alvin.mybatisplusgenerator.schoolDemo.DTO;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDTO {
    /**
     * 老师姓名
     */
    private String name;

    /**
     * 老师年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private Integer phone;

    private List<StudentDTO> itemDTOS;
}
