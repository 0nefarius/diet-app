package pl.dietap.modelfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.dietap.database.dao.ProductDao;
import pl.dietap.database.dao.models.Product;
import pl.dietap.utils.converters.ConverterProduct;
import pl.dietap.utils.exceptions.ApplicationException;

import java.util.List;

public class ProductsListModel {

    private ObservableList<ProductFx> productFxObservableList = FXCollections.observableArrayList();

    public void init() throws ApplicationException {
        ProductDao productDao = new ProductDao();
        List<Product> books = productDao.queryForAll(Product.class);
        books.forEach(book -> {
            this.productFxObservableList.add(ConverterProduct.convertToProductFx(book));
        });
    }

    public ObservableList<ProductFx> getProductFxObservableList() {
        return productFxObservableList;
    }

    public void setProductFxObservableList(ObservableList<ProductFx> productFxObservableList) {
        this.productFxObservableList = productFxObservableList;
    }
}
