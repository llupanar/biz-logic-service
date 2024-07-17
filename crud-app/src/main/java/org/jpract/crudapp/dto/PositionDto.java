package org.jpract.crudapp.dto;

public class PositionDto {
    private Long id;
    private String name;
    private Integer salary;
    private Character status;

    public PositionDto() {
        super();
    }

    public PositionDto(Long id, String name, Integer salary, Character status) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
