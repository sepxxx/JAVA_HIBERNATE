package org.example.test4OneToManyUni;

import org.example.test4OneToManyUni.entity.Department;
import org.example.test4OneToManyUni.entity.Employee;
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

//        Department department = new Department("HR",400, 150);
//        Employee e1 = new Employee("kolo", "jojo", 130);
//        Employee e2 = new Employee("zaza", "kalina", 400);
//        department.addEmployeeToDepartment(e1);
//        department.addEmployeeToDepartment(e2);

        Department department = session.get(Department.class, 3);


//        session.save(department);
        session.delete(department);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


}
