package org.example.test1;

import org.example.test1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestDelete {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.createQuery("delete Employee where name = 'Baur' ").executeUpdate();
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
