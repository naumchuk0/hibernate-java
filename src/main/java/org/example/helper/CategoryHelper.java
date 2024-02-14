package org.example.helper;

import org.example.models.Category;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.io.*;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CategoryHelper {
    public static void getCategories() {
        var sf = HibernateUtil.getSessionFactory();
        try(Session context = sf.openSession()) {
            context.beginTransaction();

            List<Category> list = context.createQuery("from Category", Category.class).getResultList();

            for (Category category : list) {
                System.out.println("Category: " + category);
            }

            context.getTransaction().commit();
        }
    }
    public static void addCategory() {
        Scanner scan = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        var session = HibernateUtil.getSessionFactory();
        try (Session context = session.openSession()){
            context.beginTransaction();
            Category category = new Category();
            System.out.println("Enter category's name: ");
            String temp = scan.nextLine();
            category.setName(temp);
            System.out.println("Enter category's image: ");
            temp = scan.nextLine();
            category.setImage(temp);
            addPhoto(temp);
            category.setCateCreated(calendar.getTime());
            context.save(category);
            context.getTransaction().commit();
        }
    }
    public static void editCategory(int id) {
        Scanner scan = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        var session = HibernateUtil.getSessionFactory();
        try (Session context = session.openSession()){
            context.beginTransaction();
            Category category = new Category();
            category.setId(id);
            System.out.println("Enter category's name: ");
            String temp = scan.nextLine();
            category.setName(temp);
            System.out.println("Enter category's image: ");
            temp = scan.nextLine();
            category.setImage(temp);
            category.setCateCreated(calendar.getTime());
            context.update(category);
            context.getTransaction().commit();
        }
    }
    public static void deleteCategory(int Id) {
        var session = HibernateUtil.getSessionFactory();
        try (Session context = session.openSession()){
            context.beginTransaction();
            Category category;
            category = (Category) context.load(Category.class,Id);
            context.delete(category);
            context.getTransaction().commit();
        }
    }
    private static void addPhoto(String namePhoto) {
        File f1 = new File("C:\\Users\\Admin\\Desktop\\Java\\Hibernate\\src\\main\\java\\org\\example\\utils\\images\\");
        f1.mkdir();
        File img = new File(f1, namePhoto);
        try(FileOutputStream fStream = new FileOutputStream(img)) {
            DataOutputStream data0 = new DataOutputStream(fStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
