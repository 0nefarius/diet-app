package pl.dietap.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import pl.dietap.database.dao.models.Product;
import pl.dietap.utils.exceptions.ApplicationException;

import java.sql.SQLException;

public class ProductDao extends CommonDao {

    public ProductDao() {
        super();
    }

    public void deleteByColumnName(String columName, int id) throws ApplicationException, SQLException {
        Dao<Product, Object> dao = getDao(Product.class);
        DeleteBuilder<Product, Object> deleteBuilder = dao.deleteBuilder();
        deleteBuilder.where().eq(columName, id);
        dao.delete(deleteBuilder.prepare());
    }

}