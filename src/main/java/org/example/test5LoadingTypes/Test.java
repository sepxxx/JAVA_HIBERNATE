package org.example.test5LoadingTypes;

import org.example.test5LoadingTypes.entity.Department;
import org.example.test5LoadingTypes.entity.Employee;
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

//        Department department = new Department("IT",1000, 450);
//        Employee e1 = new Employee("Zaur", "Tregulov", 800);
//        Employee e2 = new Employee("Alex", "Gorbuniov", 500);
//        department.addEmployeeToDepartment(e1);
//        department.addEmployeeToDepartment(e2);

        Department department = session.get(Department.class, 5);
        System.out.println(department);
        session.getTransaction().commit();
        System.out.println(department.getEmployeeList());
//        session.save(department);
        session.close();
        sessionFactory.close();
    }


}
