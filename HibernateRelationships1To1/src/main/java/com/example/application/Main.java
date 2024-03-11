package com.example.application;

import com.example.models.Customer;
import com.example.models.CustomerDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(Customer.class);
        config.addAnnotatedClass(CustomerDetails.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        Customer c1 = new Customer(1,"john");
//        CustomerDetails cd1 = new CustomerDetails(101,"john@gmail.com",1234567890,"Banglore");
//        c1.setCustomerDetails(cd1);
//        session.save(c1);
        CustomerDetails cd = session.get(CustomerDetails.class,101);
        Customer c = cd.getCustomer();
        System.out.println(c);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
