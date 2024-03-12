package com.example.application;

import com.example.models.Customer;
import com.example.models.CustomerDetails;
import com.example.models.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main1 {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(Customer.class);
        config.addAnnotatedClass(CustomerDetails.class);
        config.addAnnotatedClass(Orders.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Orders order1 = new Orders(111,"pizza",400);
        Orders order2 = new Orders(112,"burger",500);

        Customer c = session.get(Customer.class,1);
        order1.setCustomer(c);
        order2.setCustomer(c);
        session.save(order1);
        session.save(order2);
        transaction.commit();
    }
}
