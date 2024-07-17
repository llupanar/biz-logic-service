package org.jpract.crudapp.service;


import org.jpract.crudapp.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployee();

    void deleteEmployee(Long id);

    EmployeeDto createEmployee(EmployeeDto newEmployee);

    EmployeeDto updateEmployee(EmployeeDto updatedEmployee, Long id);
}
