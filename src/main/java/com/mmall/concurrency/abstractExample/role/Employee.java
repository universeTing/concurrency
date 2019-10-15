package com.mmall.concurrency.abstractExample.role;

import com.mmall.concurrency.abstractExample.AbstactPerson;
import lombok.Data;

/**
 * @author grace
 * @date   2019/10/15
 * @desctription 员工类
 */
@Data
public class Employee extends AbstactPerson {
    public String workAddress; //工作地点
    public double salary;
    public String dept;//部门
    public String job; //岗位
}
