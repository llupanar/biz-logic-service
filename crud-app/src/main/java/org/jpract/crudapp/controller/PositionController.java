package org.jpract.crudapp.controller;

import org.jpract.crudapp.dto.PositionDto;
import org.jpract.crudapp.service.PositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")

public class PositionController {

    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping
    public ResponseEntity<PositionDto> createPosition(@RequestBody PositionDto positionDto) {
        PositionDto savedPosition = positionService.createPosition(positionDto);
        return new ResponseEntity<>(savedPosition, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PositionDto> getPositionById(@PathVariable("id") Long positionId) {
        PositionDto positionDto = positionService.getPositionById(positionId);
        return ResponseEntity.ok(positionDto);
    }

    @GetMapping
    public ResponseEntity<List<PositionDto>> getAllPosition() {
        List<PositionDto> positions = positionService.getAllPosition();
        return ResponseEntity.ok(positions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PositionDto> updatePosition(@PathVariable("id") Long id, @RequestBody PositionDto positionDto) {
        PositionDto savedPosition = positionService.updatePosition(positionDto, id);
        return ResponseEntity.ok(savedPosition);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePosition(@PathVariable("id") Long positionId) {
        positionService.deletePosition(positionId);
        return ResponseEntity.ok("Deleted");
    }
}
