package org.jpract.crudapp.map;

import org.jpract.crudapp.dto.PositionDto;
import org.jpract.crudapp.model.Position;

public class PositionMapper {
    public static PositionDto mapToPositionDto(Position position) {
        return new PositionDto(
                position.getId(),
                position.getName(),
                position.getSalary(),
                position.getStatus()
        );
    }

    public static Position mapToPosition(PositionDto positionDto) {
        return new Position(
                positionDto.getId(),
                positionDto.getSalary(),
                positionDto.getName(),
                positionDto.getStatus()
        );
    }

}
