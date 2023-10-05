package ru.egartech.tmsystem.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import ru.egartech.tmsystem.model.entity.Department;
import ru.egartech.tmsystem.model.entity.Position;
import ru.egartech.tmsystem.model.entity.TimeSheet;

import java.util.List;

@Setter
@Getter
public class EmployeeDto extends EntityDto{

    //Возраст
    private int age;
    //Должность
    private Position position;
    //Отдел
    private Department department;
    //Список привилегий
    private List<String> privileges;
//    //Табель времени сотрудника
//    private List<TimeSheet> timeSheet;
}