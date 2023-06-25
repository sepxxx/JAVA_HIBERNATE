package org.example.test2OneToOne.entity;

import jakarta.persistence.*;

//jeraldin.public.employees
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String department;
    @Column
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="details_id")
    private Detail empDetail;

    public Employee() {

    }
    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Detail getEmpDetail() {
        return empDetail;
    }

    public void setEmpDetail(Detail empDetail) {
        this.empDetail = empDetail;
    }
}
