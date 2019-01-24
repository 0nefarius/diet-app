package pl.dietap.database.dao.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


@DatabaseTable(tableName = "PRODUCTS")
public class Product implements BaseModel {

    public static final String CATEGORY_ID = "CATEGORY_ID";

    public Product() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = CATEGORY_ID, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Category category;

    @DatabaseField(columnName = "NAME", canBeNull = false)
    private String name;


    @DatabaseField(columnName = "kcal")
    private int kcal;

    @DatabaseField(columnName = "Protein")
    private int protein;

    @DatabaseField(columnName = "Carb")
    private int carb;

    @DatabaseField(columnName = "Fat")
    private int fat;

    @DatabaseField(columnName = "ADDED_DATE")
    private Date addedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarb() {
        return carb;
    }

    public void setCarb (int carb) {
        this.carb = carb;
    }

    public int getFat() {
        return fat;
    }

    public void setFat (int fat) {
        this.fat = fat;
    }


    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

}