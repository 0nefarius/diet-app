package pl.dietap.modelfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.dietap.database.dao.CategoryDao;
import pl.dietap.database.dao.ProductDao;
import pl.dietap.database.dao.dbutils.DbManager;
import pl.dietap.database.dao.models.Category;
import pl.dietap.database.dao.models.Product;
import pl.dietap.utils.converters.ConverterCategory;
import pl.dietap.utils.converters.ConverterProduct;
import pl.dietap.utils.exceptions.ApplicationException;

import java.util.List;

public class ProductModel {

    private ObjectProperty<ProductFx> productFxObjectProperty = new SimpleObjectProperty<>(new ProductFx());
    private ObservableList<CategoryFx> categoryFxObservableList = FXCollections.observableArrayList();


    public void init() throws ApplicationException {

        initCategoryList();

    }

    private void initCategoryList() throws ApplicationException {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categoryList = categoryDao.queryForAll(Category.class);
        categoryFxObservableList.clear();
        categoryList.forEach(c->{
            CategoryFx categoryFx = ConverterCategory.convertToCategoryFx(c);
            categoryFxObservableList.add(categoryFx);
        });
    }

    public void saveProductInDataBase() throws ApplicationException {
        Product product = ConverterProduct.convertToProduct(this.getProductFxObjectProperty());

        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.findById(Category.class, this.getProductFxObjectProperty().getCategoryFx().getId());

        product.setCategory(category);

        ProductDao productDao = new ProductDao();
        productDao.creatOrUpdate(product);
    }

    public ProductFx getProductFxObjectProperty() {

        return productFxObjectProperty.get();
    }

    public ObjectProperty<ProductFx> productFxObjectPropertyProperty() {

        return productFxObjectProperty;
    }

    public void setProductFxObjectProperty(ProductFx productFxObjectProperty) {
        this.productFxObjectProperty.set(productFxObjectProperty);
    }

    public ObservableList<CategoryFx> getCategoryFxObservableList() {

        return categoryFxObservableList;
    }

    public void setCategoryFxObservableList(ObservableList<CategoryFx> categoryFxObservableList) {
        this.categoryFxObservableList = categoryFxObservableList;
    }
}
