package ru.egartech.tmsystem.domain.position.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionSummaryDto {
    private Long id;
    //Наименование должности
    private String name;
    //Суммарное отработанное время
    private String workTime;
    //Суммарное продуктивное время
    private String productiveTime;
    //Суммарное время отвлечений от заданных целевых программ
    private String distractionTime;
    //Суммарное время перерывов
    private String restTime;
    //Суммарное время, потраченное на обед
    private String lunchTime;
    //Переработки - разница между отработанным временем и нормой рабочего времени.
    //Может быть как положительным так и отрицательным
    private String overTime;
}
