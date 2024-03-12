package com.example.models;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "id")
   private int id;

    @Column(name = "item")
   private String item;

    @Column(name = "price")
   private int price;

    @JoinColumn(name = "cid")
    @ManyToOne(cascade = CascadeType.ALL)
   private Customer customer;
   public Orders(){}

    public Orders(int id, String item, int price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", price=" + price +
                ", customer=" + customer +
                '}';
    }
}
