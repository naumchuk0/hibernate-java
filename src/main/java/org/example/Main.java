package org.example;

import org.example.helper.CategoryHelper;
import org.example.helper.ProductHelper;
import org.example.models.Category;
import org.example.models.Product;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductHelper ph = new ProductHelper();
        CategoryHelper ch = new CategoryHelper();
//        ph.getProducts();
//        ph.addProduct();
//        ch.getCategories();
//        ch.addCategory();
    }
}