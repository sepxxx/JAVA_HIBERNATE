package org.example.test2OneToOne;

import org.example.test2OneToOne.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(org.example.test2OneToOne.entity.Employee.class)
                .addAnnotatedClass(org.example.test2OneToOne.entity.Detail.class)
                .buildSessionFactory();

//        Employee emp = new  Employee("Den", "block", "it", 980);
//        Detail empDet = new Detail("Pazan","8-991-294-50-29","dlock@mail.com");
//        emp.setEmpDetail(empDet);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.save(emp);


//        Employee employee = session.get(Detail.class, 4).getEmployee();
//        System.out.println(employee);

       Detail detail =  session.get(Detail.class, 4);
       session.delete(detail);

        //DELETE
//        Employee emp = session.get(Employee.class, 2);
//        session.delete(emp);
        //DELETE 2
//        session.createQuery("delete from Employee where salary < 900").executeUpdate();
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
