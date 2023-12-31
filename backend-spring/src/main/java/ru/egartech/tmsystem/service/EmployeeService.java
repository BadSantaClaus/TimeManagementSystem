package ru.egartech.tmsystem.service;

import ru.egartech.tmsystem.model.dto.EditEmployeeDto;
import ru.egartech.tmsystem.model.dto.EmployeeDto;
import ru.egartech.tmsystem.model.dto.EmployeeSummaryDto;
import ru.egartech.tmsystem.utils.BaseService;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService extends BaseService<EmployeeDto, Long> {
    List<EmployeeSummaryDto> employeeSummaryByPeriod(LocalDate startDate, LocalDate endDate);

    long employeeWorkTimeByPeriod(LocalDate startDate, LocalDate endDate, Long id);

    long employeeDistractionTimeByPeriod(LocalDate startDate, LocalDate endDate, Long id);

    long employeeRestTimeByPeriod(LocalDate startDate, LocalDate endDate, Long id);

    EmployeeDto update(EmployeeDto employeeDto);

    EditEmployeeDto update(EditEmployeeDto employeeDto);

    EditEmployeeDto getEditEmployeeDtoById(Long id);

    EditEmployeeDto save(EditEmployeeDto dto);

    List<EmployeeDto> findAllByPeriod(LocalDate startDate, LocalDate getEndDate);
}
