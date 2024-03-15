package com.sample.application;

import com.sample.models.Employee;
import com.sample.models.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(Employee.class);
        config.addAnnotatedClass(Project.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee john = new Employee(1,"John","john@gmail.com");
        Employee david = new Employee(2,"David","david@gmail.com");
        Employee rahul = new Employee(3,"rahul","rahul@gmail.com");

        Project pr = new Project(1,"Pr");
        Project af = new Project(2,"Af");

        ArrayList<Employee> preEmployees = new ArrayList<>();
        ArrayList<Employee> afEmployees = new ArrayList<>();

        preEmployees.add(john);
        preEmployees.add(david);
        preEmployees.add(rahul);

        afEmployees.add(john);
        afEmployees.add(rahul);

        pr.setEmployees(preEmployees);
        af.setEmployees(afEmployees);

        session.save(john);
        session.save(david);
        session.save(rahul);
        session.save(pr);
        session.save(af);

        transaction.commit();
    }
}
