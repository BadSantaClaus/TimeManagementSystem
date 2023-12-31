package ru.egartech.tmsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.egartech.tmsystem.exception.CustomEntityNotFoundException;
import ru.egartech.tmsystem.model.dto.DistractionDto;
import ru.egartech.tmsystem.model.entity.Distraction;
import ru.egartech.tmsystem.model.mapping.DistractionMapper;
import ru.egartech.tmsystem.model.repository.DistractionRepository;
import ru.egartech.tmsystem.service.DistractionService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistractionServiceImpl implements DistractionService {

    private final DistractionRepository repository;
    private final DistractionMapper mapper;

    @Override
    public List<DistractionDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public DistractionDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new CustomEntityNotFoundException(id));
    }

    @Override
    public DistractionDto save(DistractionDto dto) {
        Distraction distraction = repository.save(mapper.toEntity(dto));
        return mapper.toDto(distraction);
    }

    @Override
    public DistractionDto updateById(Long id, DistractionDto dto) {
        return repository.findById(id)
                .map(entity -> {
                    BeanUtils.copyProperties(mapper.toEntity(dto), entity, "id");
                    return mapper.toDto(repository.save(entity));
                })
                .orElseThrow(() -> new CustomEntityNotFoundException(id));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public DistractionDto save(Long timeSheetId, DistractionDto distractionDto) {
        return save(distractionDto);
    }

    @Override
    public List<DistractionDto> findByDateBetweenAndEmployee_Id(LocalDate startDate, LocalDate endDate, Long empId) {
        return repository.findByDateBetweenAndEmployee_Id(startDate, endDate, empId).stream()
                .map(mapper::toDto)
                .toList();
    }
}
