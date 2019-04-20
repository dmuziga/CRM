package com.dmuziga.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "employee")
@Getter
@Setter

@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column (name = "address")
    private String address;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn (name = "Department_id")
    @Fetch(FetchMode.JOIN)
    private Department department;

    public Employee(String name, String email, String address, Department department) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", department=" + department +
                '}';
    }
}
