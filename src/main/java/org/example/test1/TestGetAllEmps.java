package org.example.test1;

import org.example.test1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestGetAllEmps {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Employee> employeeList = session.createQuery("from Employee where name = 'Laura' AND salary > 499").getResultList();

        for(Employee e: employeeList)
            System.out.println(e);
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
