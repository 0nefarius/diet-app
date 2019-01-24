package pl.dietap.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.dietap.modelfx.CategoryFx;
import pl.dietap.modelfx.ProductModel;
import pl.dietap.utils.DialogsUtils;
import pl.dietap.utils.exceptions.ApplicationException;

public class ProductController {

    @FXML
    private TextField fatTextField;

    @FXML
    private TextField carbTextField;

    @FXML
    private TextField proteinTextField;

    @FXML
    private TextField kcalTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private ComboBox<CategoryFx> categoryCoboBox;

    private ProductModel productModel;

    @FXML
    public void initialize() {
        this.productModel = new ProductModel();
        try {
            this.productModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        bindings();
    }

    private void bindings() {
        this.categoryCoboBox.setItems(this.productModel.getCategoryFxObservableList());
        this.productModel.getProductFxObjectProperty().categoryFxProperty().bind(this.categoryCoboBox.valueProperty());
        this.productModel.getProductFxObjectProperty().nameProperty().bind(this.nameTextField.textProperty());
        this.productModel.getProductFxObjectProperty().kcalProperty().bind(this.kcalTextField.prefColumnCountProperty());
        this.productModel.getProductFxObjectProperty().proteinProperty().bind(this.proteinTextField.prefColumnCountProperty());
        this.productModel.getProductFxObjectProperty().carbProperty().bind(this.carbTextField.prefColumnCountProperty());
        this.productModel.getProductFxObjectProperty().fatProperty().bind(this.fatTextField.prefColumnCountProperty());
    }

    public void addProductOnAction() {
        try {
            this.productModel.saveProductInDataBase();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
}
