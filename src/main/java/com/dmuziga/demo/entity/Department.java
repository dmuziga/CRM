package com.dmuziga.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table (name = "department")
public class Department implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column (name = " Description")
    private String description;

    @OneToMany (targetEntity = Employee.class, mappedBy = "id")
    private Set<Employee>  employees;


    public Department() {
    }

    public Department(String name, String description, Set<Employee> employees) {
        this.name = name;
        this.description = description;
        this.employees = employees;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", employees=" + employees +
                '}';
    }


}
