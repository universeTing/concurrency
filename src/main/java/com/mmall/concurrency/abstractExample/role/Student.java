package com.mmall.concurrency.abstractExample.role;

import com.mmall.concurrency.abstractExample.AbstactPerson;
import lombok.Data;

/**
 * 学生类
 */
@Data
public class Student extends AbstactPerson {
    public String classNo;//班级号
    public String schoolName;//学校名
    public String studentNo;//学号
    public int range; //排名



}
