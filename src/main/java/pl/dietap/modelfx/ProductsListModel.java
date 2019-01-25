package pl.dietap.modelfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.dietap.database.dao.CategoryDao;
import pl.dietap.database.dao.ProductDao;
import pl.dietap.database.dao.models.Category;
import pl.dietap.database.dao.models.Product;
import pl.dietap.utils.converters.ConverterCategory;
import pl.dietap.utils.converters.ConverterProduct;
import pl.dietap.utils.exceptions.ApplicationException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductsListModel {

    private ObservableList<ProductFx> productFxObservableList = FXCollections.observableArrayList();
    private ObservableList<CategoryFx> categoryFxObservableList = FXCollections.observableArrayList();

    private ObjectProperty<Category> categoryFxObjectProperty = new SimpleObjectProperty<>();
    private List<ProductFx> productFxList = new ArrayList<>();


    public void init() throws ApplicationException {
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.queryForAll(Product.class);
        productFxList.clear();
        products.forEach(product -> {
            this.productFxList.add(ConverterProduct.convertToProductFx(product));
        });
        this.productFxObservableList.setAll(productFxList);

        initCategory();
    }

    public void filterProductList() {
        if(getCategoryFxObjectProperty() != null) {
            filterPredicate(predicateCategory());
        } else if(getCategoryFxObjectProperty() != null) {
            filterPredicate(predicateCategory());
        } else {
            this.productFxObservableList.setAll(this.productFxList);
        }

    }

    public void deleteProduct(ProductFx productFx) throws ApplicationException {
        ProductDao productDao = new ProductDao();
        productDao.deleteById(Product.class, productFx.getId());
        init();
    }

    private void initCategory() throws ApplicationException {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.queryForAll(Category.class);
        this.categoryFxObservableList.clear();
        categories.forEach(c-> {
            CategoryFx categoryFx = ConverterCategory.convertToCategoryFx(c);
            this.categoryFxObservableList.add(categoryFx);
        });
    }



    private Predicate<ProductFx> predicateCategory() {
        return productFx -> productFx.getCategoryFx().getId() == getCategoryFxObjectProperty().getId();
    }

    private void filterPredicate(Predicate<ProductFx> predicate) {
        List<ProductFx> newList = productFxList.stream().filter(predicate).collect(Collectors.toList());
        this.productFxObservableList.setAll(newList);
    }

    public ObservableList<ProductFx> getProductFxObservableList() {
        return productFxObservableList;
    }

    public void setProductFxObservableList(ObservableList<ProductFx> productFxObservableList) {
        this.productFxObservableList = productFxObservableList;
    }

    public ObservableList<CategoryFx> getCategoryFxObservableList() {
        return categoryFxObservableList;
    }

    public void setCategoryFxObservableList(ObservableList<CategoryFx> categoryFxObservableList) {
        this.categoryFxObservableList = categoryFxObservableList;
    }

    public Category getCategoryFxObjectProperty() {
        return categoryFxObjectProperty.get();
    }

    public ObjectProperty<Category> categoryFxObjectPropertyProperty() {
        return categoryFxObjectProperty;
    }

    public void setCategoryFxObjectProperty(Category categoryFxObjectProperty) {
        this.categoryFxObjectProperty.set(categoryFxObjectProperty);
    }
}
