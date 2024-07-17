package org.jpract.crudapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Character status;

    @OneToMany(mappedBy = "position", cascade = CascadeType.REMOVE)
    private List<Employee> employees;

    public Position() {
        super();
    }

    public Position(Long id, Integer salary, String name, Character status) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
