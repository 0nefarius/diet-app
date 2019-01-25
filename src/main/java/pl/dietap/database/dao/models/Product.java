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


    @DatabaseField(columnName = "kcal", canBeNull = false)
    private String kcal;

    @DatabaseField(columnName = "Protein", canBeNull = false)
    private String protein;

    @DatabaseField(columnName = "Carb", canBeNull = false)
    private String carb;

    @DatabaseField(columnName = "Fat", canBeNull = false)
    private String fat;


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

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getCarb() {
        return carb;
    }

    public void setCarb (String carb) {
        this.carb = carb;
    }

    public String getFat() {
        return fat;
    }

    public void setFat (String fat) {
        this.fat = fat;
    }


}