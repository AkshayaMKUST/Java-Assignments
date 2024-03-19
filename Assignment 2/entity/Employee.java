package com.employee.Employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    private Integer employeeId;
    private String employeeName;
    private String employeeDepartment;
    private float employeeSalary;
}
