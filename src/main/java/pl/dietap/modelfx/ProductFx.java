package pl.dietap.modelfx;

import javafx.beans.property.*;

public class ProductFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<CategoryFx> categoryFx = new SimpleObjectProperty<>();
    private SimpleStringProperty name = new SimpleStringProperty();
    private IntegerProperty kcal = new SimpleIntegerProperty();
    private IntegerProperty protein = new SimpleIntegerProperty();
    private IntegerProperty carb = new SimpleIntegerProperty();
    private IntegerProperty fat = new SimpleIntegerProperty();

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

    public int getKcal() {
        return kcal.get();
    }

    public IntegerProperty kcalProperty() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal.set(kcal);
    }

    public int getProtein() {
        return protein.get();
    }

    public IntegerProperty proteinProperty() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein.set(protein);
    }

    public int getCarb() {
        return carb.get();
    }

    public IntegerProperty carbProperty() {
        return carb;
    }

    public void setCarb(int carb) {
        this.carb.set(carb);
    }

    public int getFat() {
        return fat.get();
    }

    public IntegerProperty fatProperty() {
        return fat;
    }

    public void setFat(int fat) {
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