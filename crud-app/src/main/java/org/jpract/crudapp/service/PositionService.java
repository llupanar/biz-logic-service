package org.jpract.crudapp.service;

import org.jpract.crudapp.dto.PositionDto;

import java.util.List;

public interface PositionService {
    PositionDto getPositionById(Long id);

    List<PositionDto> getAllPosition();

    void deletePosition(Long id);

    PositionDto createPosition(PositionDto newPosition);

    PositionDto updatePosition(PositionDto updatedPosition, Long id);
}
