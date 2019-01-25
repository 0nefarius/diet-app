package pl.dietap.modelfx;

import javafx.beans.property.*;

public class ProductFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<CategoryFx> categoryFx = new SimpleObjectProperty<>();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty kcal = new SimpleStringProperty();
    private SimpleStringProperty protein = new SimpleStringProperty();
    private SimpleStringProperty carb = new SimpleStringProperty();
    private SimpleStringProperty fat = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public CategoryFx getCategoryFx() {
        return categoryFx.get();
    }

    public ObjectProperty<CategoryFx> categoryFxProperty() {
        return categoryFx;
    }

    public void setCategoryFx(CategoryFx categoryFx) {
        this.categoryFx.set(categoryFx);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getKcal() {
        return kcal.get();
    }

    public SimpleStringProperty kcalProperty() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal.set(kcal);
    }

    public String getProtein() {
        return protein.get();
    }

    public SimpleStringProperty proteinProperty() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein.set(protein);
    }

    public String getCarb() {
        return carb.get();
    }

    public SimpleStringProperty carbProperty() {
        return carb;
    }

    public void setCarb(String carb) {
        this.carb.set(carb);
    }

    public String getFat() {
        return fat.get();
    }

    public SimpleStringProperty fatProperty() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat.set(fat);
    }

    @Override
    public String toString() {
        return "BookFx{" +
                "id=" + id.get() +
                ", categoryFx=" + categoryFx.get() +
                ", name=" + name.get() +
                ", kcal=" + kcal.get() +
                ", protein=" + protein.get() +
                ", carb=" + carb.get() +
                ", fat=" + fat.get() +
                '}';
    }
}