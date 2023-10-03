package ru.egartech.tmsystem.domain.timesheet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egartech.tmsystem.domain.timesheet.dto.TimeSheetDto;
import ru.egartech.tmsystem.domain.timesheet.entity.TimeSheet;
import ru.egartech.tmsystem.domain.timesheet.mapper.TimeSheetMapper;
import ru.egartech.tmsystem.domain.timesheet.repository.TimeSheetRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeSheetServiceImpl implements TimeSheetService{

    private final TimeSheetRepository repository;
    private final TimeSheetMapper mapper;

    @Override
    public List<TimeSheetDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<TimeSheetDto> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public TimeSheetDto save(TimeSheetDto dto) {
        TimeSheet timeSheet = repository.save(mapper.toEntity(dto));
        return mapper.toDto(timeSheet);
    }

    @Override
    public TimeSheetDto updateById(Long id, TimeSheetDto dto) {
        return repository.findById(id)
                .map(t -> mapper.toDto(repository.save(t)))
                .orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}