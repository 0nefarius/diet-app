package pl.dietap.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.dietap.modelfx.ProductFx;
import pl.dietap.modelfx.CategoryFx;
import pl.dietap.modelfx.ProductsListModel;
import pl.dietap.utils.DialogsUtils;
import pl.dietap.utils.FxmlUtils;
import pl.dietap.utils.exceptions.ApplicationException;



public class ProductListController {

    @FXML
    private javafx.scene.control.TableView<ProductFx> productsTableView;

    @FXML
    private TableColumn<ProductFx, String> nameColumn;

    @FXML
    private TableColumn<ProductFx, String> categoryColumn;

    @FXML
    private TableColumn<ProductFx, String> kcalColumn;

    @FXML
    private TableColumn<ProductFx, String> proteinColumn;

    @FXML
    private TableColumn<ProductFx, String> carbColumn;

    @FXML
    private TableColumn<ProductFx, String> fatColumn;

    private ProductsListModel productsListModel;

    @FXML
    void initialize() {
        this.productsListModel = new ProductsListModel();
        try {
            this.productsListModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.productsTableView.setItems(this.productsListModel.getProductFxObservableList());
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        //this.categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryFxProperty());
        this.kcalColumn.setCellValueFactory(cellData -> cellData.getValue().kcalProperty());
        this.proteinColumn.setCellValueFactory(cellData -> cellData.getValue().proteinProperty());
        this.carbColumn.setCellValueFactory(cellData -> cellData.getValue().carbProperty());
        this.fatColumn.setCellValueFactory(cellData -> cellData.getValue().fatProperty());
    }

}
