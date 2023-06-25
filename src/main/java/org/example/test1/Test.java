package org.example.test1;

import org.example.test1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Employee emp = new Employee("Laura", "Brest", "HR", 500);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.save(emp);
        Employee employee = session.get(Employee.class, 2);
        System.out.println(employee);
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
