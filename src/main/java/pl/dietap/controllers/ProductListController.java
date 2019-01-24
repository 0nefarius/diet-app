package pl.dietap.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import pl.dietap.modelfx.ProductFx;

import javax.swing.text.TableView;

public class ProductListController {

    @FXML
    private javafx.scene.control.TableView<ProductFx> productsTableView;

    @FXML
    private TableColumn<ProductFx, String> nameColumn;

    @FXML
    private TableColumn<ProductFx, String> categoryColumn;

    @FXML
    private TableColumn<ProductFx, Number> kcalColumn;

    @FXML
    private TableColumn<ProductFx, Number> proteinColumn;

    @FXML
    private TableColumn<ProductFx, Number> carbColumn;

    @FXML
    private TableColumn<ProductFx, Number> fatColumn;




    @FXML
    void initialize() {


    }
}
