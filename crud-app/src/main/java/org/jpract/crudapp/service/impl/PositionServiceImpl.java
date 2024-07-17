package org.jpract.crudapp.service.impl;

import org.jpract.crudapp.dto.PositionDto;
import org.jpract.crudapp.exception.ResourceNotFoundException;
import org.jpract.crudapp.map.PositionMapper;
import org.jpract.crudapp.model.Position;
import org.jpract.crudapp.repository.EmployeeRepository;
import org.jpract.crudapp.repository.PositionRepository;
import org.jpract.crudapp.service.PositionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    private PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public PositionDto createPosition(PositionDto newPosition) {

        Position position = PositionMapper.mapToPosition(newPosition);
        Position savedPosition = positionRepository.save(position);
        return PositionMapper.mapToPositionDto(savedPosition);
    }

    @Override
    public PositionDto updatePosition(PositionDto updatedPosition, Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Position with id " + id + " not found"));

        position.setName(updatedPosition.getName());
        position.setSalary(updatedPosition.getSalary());
        position.setStatus(updatedPosition.getStatus());

        Position savedPosition = positionRepository.save(position);
        return PositionMapper.mapToPositionDto(savedPosition);
    }

    @Override
    public PositionDto getPositionById(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Position with id " + id + " not found"));
        return PositionMapper.mapToPositionDto(position);
    }

    @Override
    public List<PositionDto> getAllPosition() {
        List<Position> positions = positionRepository.findAll();
        return positions.stream().map(PositionMapper::mapToPositionDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePosition(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Position with id " + id + " not found"));
        positionRepository.deleteById(id);
    }
}
