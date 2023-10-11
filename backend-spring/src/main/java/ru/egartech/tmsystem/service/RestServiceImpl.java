package ru.egartech.tmsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.egartech.tmsystem.exception.RestNotFoundException;
import ru.egartech.tmsystem.exception.TimeSheetNotFoundException;
import ru.egartech.tmsystem.model.dto.RestDto;
import ru.egartech.tmsystem.model.entity.Rest;
import ru.egartech.tmsystem.model.mapping.RestMapper;
import ru.egartech.tmsystem.model.mapping.TimeSheetMapper;
import ru.egartech.tmsystem.model.repository.RestRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RestServiceImpl implements RestService {

    private final RestRepository repository;
    private final TimeSheetService timeSheetService;
    private final RestMapper mapper;
    private final TimeSheetMapper timeSheetMapper;

    @Override
    public List<RestDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }
    @Override
    public Optional<RestDto> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public RestDto save(RestDto dto) {
        Rest rest = repository.save(mapper.toEntity(dto));
        return mapper.toDto(rest);
    }

    @Override
    public RestDto updateById(Long id, RestDto dto) {
        return repository.findById(id)
                .map(entity -> {
                    BeanUtils.copyProperties(mapper.toEntity(dto), entity, "id");
                    return mapper.toDto(repository.save(entity));
                })
                .orElseThrow(RestNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public RestDto update(Long timeSheetId, Long restId, RestDto restDto) {
        restDto.setTimeSheet(timeSheetMapper.toEntity(timeSheetService.findById(timeSheetId)
                .orElseThrow(RestNotFoundException::new)));
        return updateById(restId, restDto);
    }

    @Override
    public RestDto save(Long timeSheetId, RestDto dto) {
        dto.setTimeSheet(timeSheetMapper.toEntity(timeSheetService.findById(timeSheetId).orElseThrow(TimeSheetNotFoundException::new)));
        return save(dto);
    }
}