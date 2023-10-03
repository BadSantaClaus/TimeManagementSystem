package ru.egartech.tmsystem.domain.department.dto;

import lombok.Getter;
import lombok.Setter;
import ru.egartech.tmsystem.domain.employee.entity.Employee;

import java.util.List;

@Getter
@Setter
public class DepartmentDto {
    //Название отдела
    String name;
    //Сотрудники отдела
    List<Employee> employees;
}