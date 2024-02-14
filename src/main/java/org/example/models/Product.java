package org.example.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", length = 4000)
    private String description;

    @Column(length = 200)
    private String image;

    private double price;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", category=" + category.getName() +
                '}';
    }
}