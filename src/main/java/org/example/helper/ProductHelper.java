package org.example.helper;

import org.example.models.Category;
import org.example.models.Product;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ProductHelper {
    public static void addProduct() {
        Scanner scan = new Scanner(System.in);
        var session = HibernateUtil.getSessionFactory();
        try (Session context = session.openSession()){
            context.beginTransaction();
            Product product = new Product();
            System.out.println("Enter product's name: ");
            String temp = scan.nextLine();
            product.setName(temp);

            System.out.println("Enter product's description: ");
            temp = scan.nextLine();
            product.setDescription(temp);

            System.out.println("Enter product's price: ");
            double price = scan.nextDouble();
            product.setPrice(price);

            System.out.println("Enter product's image: ");
            temp = scan.next();
            product.setImage(temp);

            System.out.println("Enter product's category: ");
            Category cate = new Category();
            cate.setId(scan.nextInt());
            product.setCategory(cate);


            context.save(product);
            context.getTransaction().commit();
        }
    }
    public static void editProduct(int id) {
        Scanner scan = new Scanner(System.in);
        var session = HibernateUtil.getSessionFactory();
        try (Session context = session.openSession()){
            context.beginTransaction();
            Product product = new Product();
            product.setId(id);
            System.out.println("Enter product's name: ");
            String temp = scan.nextLine();
            product.setName(temp);

            System.out.println("Enter product's description: ");
            temp = scan.nextLine();
            product.setDescription(temp);

            System.out.println("Enter category's image: ");
            temp = scan.nextLine();
            product.setImage(temp);

            System.out.println("Enter product's price: ");
            double price = scan.nextDouble();
            product.setPrice(price);

            System.out.println("Enter product's category: ");
            Category cate = new Category();
            cate.setId(scan.nextInt());
            product.setCategory(cate);

            context.update(product);
            context.getTransaction().commit();
        }
    }
    public static void deleteProduct(int id) {
        var session = HibernateUtil.getSessionFactory();
        try (Session context = session.openSession()){
            context.beginTransaction();
            Product product;
            product = (Product) context.load(Product.class,id);
            context.delete(product);
            context.getTransaction().commit();
        }
    }
    public static void getProducts() {
        var sf = HibernateUtil.getSessionFactory();
        try(Session context = sf.openSession()) {
            context.beginTransaction();

            List<Product> list = context.createQuery("from Product", Product.class).getResultList();

            for (Product product : list) {
                System.out.println("Product: " + product);
            }

            context.getTransaction().commit();
        }
    }
}
