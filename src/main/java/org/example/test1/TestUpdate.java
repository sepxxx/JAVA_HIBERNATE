package org.example.test1;

import org.example.test1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestUpdate {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //1 var
//        Employee emp = session.get(Employee.class, 2);
//        emp.setSalary(0);
        //2 var
        session.createQuery("update Employee set salary = 0 ").executeUpdate();
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
