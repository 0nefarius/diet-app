package pl.dietap.utils;

import pl.dietap.database.dao.ProductDao;
import pl.dietap.database.dao.CategoryDao;
import pl.dietap.database.dao.dbutils.DbManager;
import pl.dietap.database.dao.models.Product;
import pl.dietap.database.dao.models.Category;
import pl.dietap.utils.exceptions.ApplicationException;

import java.util.Date;

public class FillDatabase {
    public static  void fillDatabase() {
        Category category1 = new Category();
        category1.setName("Nabiał");
        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setName("Jajko");
        product1.setKcal("100");
        product1.setProtein("4");
        product1.setCarb("10");
        product1.setFat("8");

        Category category2 = new Category();
        category2.setName("Mięso");
        CategoryDao categoryDao = new CategoryDao();
        try {
            categoryDao.creatOrUpdate(category2);
            DbManager.closeConnectionSource();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


        Category category3 = new Category();
        category3.setName("Warzywa");
        Product product2 = new Product();
        product2.setCategory(category3);
        product2.setName("Ziemniak");
        product2.setKcal("80");
        product2.setProtein("2");
        product2.setCarb("12");
        product2.setFat("3");

        Category category4 = new Category();
        category4.setName("Owoce");
        Product product3 = new Product();
        product3.setCategory(category4);
        product3.setName("Banan");
        product3.setKcal("50");
        product3.setProtein("10");
        product3.setCarb("25");
        product3.setFat("2");

        Product product4 = new Product();
        product4.setCategory(category4);
        product4.setName("Kiwi");
        product4.setKcal("30");
        product4.setProtein("1");
        product4.setCarb("4");
        product4.setFat("1");

        ProductDao productDao = new ProductDao();
        try {
            productDao.creatOrUpdate(product1);
            productDao.creatOrUpdate(product2);
            productDao.creatOrUpdate(product3);
            productDao.creatOrUpdate(product4);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        DbManager.closeConnectionSource();
    }
}