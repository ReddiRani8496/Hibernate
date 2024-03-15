package com.sample.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.util.List;
@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project", joinColumns=@JoinColumn(name = "proj_id"),inverseJoinColumns = @JoinColumn(name = "emp_id"))
    private List<Employee> employees;

    public Project(){}

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
