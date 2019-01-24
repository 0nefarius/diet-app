package pl.dietap.utils.converters;

import pl.dietap.database.dao.models.Product;
import pl.dietap.modelfx.ProductFx;

public class ConverterProduct {

    public static Product convertToProduct(ProductFx productFx) {
        Product product = new Product();
        product.setId(productFx.getId());
        product.setName(productFx.getName());
        product.setKcal(productFx.getKcal());
        product.setProtein(productFx.getProtein());
        product.setCarb(productFx.getCarb());
        product.setFat(productFx.getFat());

        return product;
    }

    public static ProductFx convertToProductFx(Product product) {
        ProductFx productFx = new ProductFx();
        productFx.setId(product.getId());
        productFx.setName(product.getName());
        productFx.setKcal(product.getKcal());
        productFx.setProtein(product.getProtein());
        productFx.setCarb(product.getCarb());
        productFx.setFat(product.getFat());
        productFx.setCategoryFx(ConverterCategory.convertToCategoryFx(product.getCategory()));
        return productFx;
    }
}
