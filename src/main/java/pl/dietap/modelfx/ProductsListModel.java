package pl.dietap.modelfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.dietap.database.dao.ProductDao;
import pl.dietap.database.dao.models.Product;
import pl.dietap.utils.converters.ConverterProduct;
import pl.dietap.utils.exceptions.ApplicationException;

import java.util.List;

public class ProductsListModel {

    private ObservableList<ProductFx> bookFxObservableList = FXCollections.observableArrayList();
    private List<Product> productFxObservableList;

    public void init() throws ApplicationException {
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.queryForAll(Product.class);
        products.forEach(product->{
            this.productFxObservableList.add(ConverterProduct.convertToProductFx(product));
        });
    }

    public ObservableList<ProductFx> getBookFxObservableList() {
        return bookFxObservableList;
    }

    public void setBookFxObservableList(ObservableList<ProductFx> bookFxObservableList) {
        this.bookFxObservableList = bookFxObservableList;
    }

    public List<Product> getProductFxObservableList() {
        return productFxObservableList;
    }

    public void setProductFxObservableList(List<Product> productFxObservableList) {
        this.productFxObservableList = productFxObservableList;
    }
}
