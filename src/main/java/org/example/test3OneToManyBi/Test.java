package org.example.test3OneToManyBi;

import org.example.test3OneToManyBi.entity.Department;
import org.example.test3OneToManyBi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();



        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Department department = new Department("IT",1000, 450);
        Employee e1 = new Employee("Zaur", "Tregulov", 800);
        Employee e2 = new Employee("Alex", "Gorbuniov", 500);
        department.addEmployeeToDepartment(e1);
        department.addEmployeeToDepartment(e2);


        session.save(department);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


}
