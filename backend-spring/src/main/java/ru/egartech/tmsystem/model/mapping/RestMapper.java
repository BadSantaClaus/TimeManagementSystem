package ru.egartech.tmsystem.model.mapping;

import org.mapstruct.Mapper;
import ru.egartech.tmsystem.model.dto.RestDto;
import ru.egartech.tmsystem.model.entity.Rest;

import java.time.Duration;

@Mapper(componentModel = "spring")
public abstract class RestMapper {

    public abstract RestDto toDto(Rest rest);

    public Rest toEntity(RestDto dto) {
        Rest rest = new Rest();
        rest.setDate(dto.getDate());
        rest.setStartRest(dto.getStartRest());
        rest.setEndRest(dto.getEndRest());
        rest.setRestTime(Duration.between(dto.getStartRest(), dto.getEndRest()).toMinutes());
        rest.setTimeSheet(dto.getTimeSheet());

        return rest;
    }
}