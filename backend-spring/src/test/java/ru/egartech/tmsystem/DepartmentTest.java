package ru.egartech.tmsystem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import ru.egartech.tmsystem.model.dto.*;
import ru.egartech.tmsystem.service.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DepartmentTest {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RestService restService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DistractionService distractionService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TimeSheetService timeSheetService;

    private LocalDate startDate;
    private LocalDate endDate;
    private Long workTime;
    private Long restTime;
    private Long distractionTime;
    private DepartmentDto department;

    @BeforeEach
    void init() {
        startDate = LocalDate.of(2023, 10, 18);
        endDate = LocalDate.of(2023, 10, 21);

        LocalDate date1 = LocalDate.of(2023, 10, 19);
        LocalDate date2 = LocalDate.of(2023, 10, 20);

        LocalTime startWork = LocalTime.of(9, 0);
        LocalTime endWork = LocalTime.of(18, 0);

        LocalTime startRest = LocalTime.of(9, 15);
        LocalTime endRest = LocalTime.of(9, 30);

        LocalTime startDistraction = LocalTime.of(10, 0);
        LocalTime endDistraction = LocalTime.of(10, 40);

        workTime = Duration.between(startWork, endWork).toMinutes() * 2;
        restTime = Duration.between(startRest, endRest).toMinutes() * 2;
        distractionTime = Duration.between(startDistraction, endDistraction).toMinutes() * 2;

        department = departmentService.save(new DepartmentDto("IT"));

        PositionDto position1 = positionService.save(new PositionDto("QA", department));
        PositionDto position2 = positionService.save(new PositionDto("TeamLead", department));

        EmployeeDto employee1 = employeeService.save(new EmployeeDto("Petr", 29, position1));
        EmployeeDto employee2 = employeeService.save(new EmployeeDto("Ivan", 32, position2));

        TimeSheetDto timeSheet1 = new TimeSheetDto(date1, startWork, endWork, employee1);
        TimeSheetDto timeSheet2 = new TimeSheetDto(date2, startWork, endWork, employee2);
        RestDto restDto1 = new RestDto(date1, startRest, endRest, employee1);
        RestDto restDto2 = new RestDto(date2, startRest, endRest, employee2);
        DistractionDto distractionDto1 = new DistractionDto(date1, startDistraction, endDistraction, employee1);
        DistractionDto distractionDto2 = new DistractionDto(date2, startDistraction, endDistraction, employee2);

        restService.save(restDto1);
        restService.save(restDto2);

        distractionService.save(distractionDto1);
        distractionService.save(distractionDto2);

        timeSheetService.save(timeSheet1);
        timeSheetService.save(timeSheet2);
    }

    @Test
    @DisplayName("Тест - суммарное время перерывов")
    void departmentRestTimeByPeriodTest() {
        Assertions.assertThat(departmentService.departmentRestTimeByPeriod(startDate, endDate, department.getId()))
                .describedAs(String.format("Проверяем, что суммарное время перерывов %d мин", restTime))
                .isEqualTo(restTime);
    }

    @Test
    @DisplayName("Тест - суммарное время отвлечений")
    void departmentDistractionTimeByPeriodTest() {
        Assertions.assertThat(departmentService.departmentDistractionTimeByPeriod(startDate, endDate, department.getId()))
                .describedAs(String.format("Проверяем, что суммарное время отвлечений %d мин", distractionTime))
                .isEqualTo(distractionTime);
    }

    @Test
    @DisplayName("Тест - суммарное отработанное время")
    void departmentWorkTimeByPeriodTest() {
        Assertions.assertThat(departmentService.departmentWorkTimeByPeriod(startDate, endDate, department.getId()))
                .describedAs(String.format("Проверяем, что суммарное отработанное время %d мин", workTime))
                .isEqualTo(workTime);
    }

}