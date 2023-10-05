package ru.egartech.tmsystem.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//Отклонения от нормы по каждому сотруднику, рассчитывается за месяц
public class DeviationDto {

    //Полное имя сотрудника
    private String employeeName;
    //Суммарное количество отклонений
    private String deviationCount;
    //Суммарное количество опозданий
    private String lateCount;
    //Суммарное количество ранних уходов
    private String earlyLeavingCount;
    //Суммарное количество отсутствий
    private String absenceCount;
    //Суммарное количество пропусков
    private String skipCount;
    //Суммарное количество превышений времени отвлечений
    private String excessDistractionTimeCount;
    //Суммарное количество превышений обеденного времени
    private String excessLunchTimeCount;
    //Суммарное количество превышений времени отвлечений
    private String excessRestTimeCount;
    //Список привилегий
    private String privileges;
}