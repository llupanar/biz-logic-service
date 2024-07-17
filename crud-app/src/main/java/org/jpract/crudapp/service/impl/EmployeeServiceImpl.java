package org.jpract.crudapp.service.impl;

import org.jpract.crudapp.dto.EmployeeDto;
import org.jpract.crudapp.exception.ResourceNotFoundException;
import org.jpract.crudapp.map.EmployeeMapper;
import org.jpract.crudapp.model.Employee;
import org.jpract.crudapp.model.Position;
import org.jpract.crudapp.repository.EmployeeRepository;
import org.jpract.crudapp.repository.PositionRepository;
import org.jpract.crudapp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
    }


    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + id + " not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + id + " not found"));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto newEmployee) {
        Position position = positionRepository.findById(newEmployee.getPositionId())
                .orElseThrow(() -> new RuntimeException("Position not found"));
        Employee employee = EmployeeMapper.mapToEmployee(newEmployee);
        employee.setPosition(position);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto updatedEmployee, Long id) {

        Position position = positionRepository.findById(updatedEmployee.getPositionId())
                .orElseThrow(() -> new RuntimeException("Position not found"));
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + id + " not found"));
        Employee updatedEmployeeObj = EmployeeMapper.mapToEmployee(updatedEmployee);
        employee.setFullName(updatedEmployeeObj.getFullName());
        employee.setBirthDate(updatedEmployeeObj.getBirthDate());
        employee.setGender(updatedEmployeeObj.getGender());
        employee.setPosition(position);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
