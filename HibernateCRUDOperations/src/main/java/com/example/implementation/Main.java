package com.example.implementation;

import com.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // Assuming your Hibernate configuration file is named hibernate.cfg.xml
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // CRUD operations
        // Student s1 = new Student(5, "john", "john@gmail.com");
        // session.save(s1);
        // Student s2 = new Student(6, "king", "king@gmail.com");
        // session.save(s2);

        // retrieve the data
//        Student s = session.get(Student.class,4);
//        System.out.println(s);

//        String query = "from Student s where s.marks>=90";
//        List<Student> students = session.createQuery(query, Student.class).list();
//        for (Student student : students)
//            System.out.println(student);
//
        // update operations
//        Student s = session.get(Student.class,7);
//        s.setMarks(50);
//        session.update(s);

//        String query = "update Student s set s.marks=80 where s.id=7";
//        session.createQuery(query).executeUpdate();
//        Student s = new Student(9,"virat","virat@gmail.com",85);
//        session.update(s);


        // delete operation

//        Student s = session.get(Student.class,7);
//        session.delete(s);

        String query = "delete Student";
        session.createQuery(query).executeUpdate();




        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
