package org.jpract.crudapp.map;

import org.jpract.crudapp.dto.EmployeeDto;
import org.jpract.crudapp.model.Employee;
import org.jpract.crudapp.model.Position;


public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFullName(),
                employee.getBirthDate(),
                employee.getGender(),
                employee.getPositionId(),
                employee.getPositionName()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFullName(employeeDto.getFullName());
        employee.setBirthDate(employeeDto.getBirthDate());
        employee.setGender(employeeDto.getGender());
        Position position = new Position();
        position.setId(employeeDto.getPositionId());
        employee.setPosition(position);
        return employee;
    }
}
