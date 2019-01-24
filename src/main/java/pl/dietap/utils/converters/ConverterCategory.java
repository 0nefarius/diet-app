package pl.dietap.utils.converters;

import pl.dietap.database.dao.models.Category;
import pl.dietap.modelfx.CategoryFx;

public class ConverterCategory {


    public static CategoryFx convertToCategoryFx(Category category) {
        CategoryFx categoryFx = new CategoryFx();
        categoryFx.setId(category.getId());
        categoryFx.setName(category.getName());
        return categoryFx;
    }
}
