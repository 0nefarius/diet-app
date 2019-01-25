package pl.dietap.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.dietap.modelfx.CategoryFx;
import pl.dietap.modelfx.ProductModel;
import pl.dietap.utils.DialogsUtils;
import pl.dietap.utils.exceptions.ApplicationException;

public class ProductController {

    @FXML
    public Button addButton;

    @FXML
    private ComboBox<CategoryFx> categoryCoboBox;

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
        validation();
    }

    private void validation() {
        this.addButton.disableProperty().bind(this.categoryCoboBox.valueProperty().isNull()
                .or(this.nameTextField.textProperty().isNull())
                .or(this.kcalTextField.textProperty().isEmpty())
                .or(this.proteinTextField.textProperty().isEmpty())
                .or(this.carbTextField.textProperty().isEmpty())
                .or(this.fatTextField.textProperty().isNull()));
    }

    public void bindings() {
        this.categoryCoboBox.setItems(this.productModel.getCategoryFxObservableList());

        this.categoryCoboBox.valueProperty().bindBidirectional(this.productModel.getProductFxObjectProperty().categoryFxProperty());
        this.nameTextField.textProperty().bindBidirectional(this.productModel.getProductFxObjectProperty().nameProperty());
        this.kcalTextField.textProperty().bindBidirectional(this.productModel.getProductFxObjectProperty().kcalProperty());
        this.proteinTextField.textProperty().bindBidirectional(this.productModel.getProductFxObjectProperty().proteinProperty());
        this.carbTextField.textProperty().bindBidirectional(this.productModel.getProductFxObjectProperty().carbProperty());
        this.fatTextField.textProperty().bindBidirectional(this.productModel.getProductFxObjectProperty().fatProperty());
    }

    public void addProductOnAction() {
        try {
            this.productModel.saveProductInDataBase();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

/*
   private void clearFields() {
        this.categoryCoboBox.getSelectionModel().clearSelection();
        this.nameTextField.clear();
        this.kcalTextField.clear();                                 NIE UZYWAM METODY BO PODCZAS EDYCJI USUWA DANE W TABELI
        this.proteinTextField.clear();
        this.carbTextField.clear();
        this.fatTextField.clear();
    }
*/

    public ProductModel getProductModel() {
        return productModel;
    }
}
