package org.example.test6ManyToManyPart1;

import org.example.test6ManyToManyPart1.entity.Child;
import org.example.test6ManyToManyPart1.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        Section section = new Section("Football");
        Child c1 = new Child(11, "Igor");
        Child c2 = new Child(13, "Egor");
        Child c3 = new Child(10, "Elena");
        section.addChildToSection(c1);
        section.addChildToSection(c2);
        section.addChildToSection(c3);


        try(
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();) {
            session.beginTransaction();
//            session.persist(section);
            Section section1 = session.get(Section.class, 4);
            session.delete(section1);
            session.getTransaction().commit();
        }
    }
}
