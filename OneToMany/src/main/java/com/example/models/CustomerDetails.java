package com.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "customerDetails")
public class CustomerDetails {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy = "customerDetails",cascade = CascadeType.ALL)
    private Customer customer;

    public CustomerDetails(){}

    public CustomerDetails(int id, String email, int phone, String address) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }
}
