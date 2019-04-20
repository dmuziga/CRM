package com.dmuziga.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table (name = "department")
@Data
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



}
