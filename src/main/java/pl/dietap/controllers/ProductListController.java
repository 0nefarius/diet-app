package pl.dietap.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
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

import java.io.IOException;


public class ProductListController {

    @FXML
    private ComboBox categoryComboBox;

    @FXML
    private javafx.scene.control.TableView<ProductFx> productsTableView;

    @FXML
    private TableColumn<ProductFx, String> nameColumn;

    @FXML
    private TableColumn<ProductFx, CategoryFx> categoryColumn;

    @FXML
    private TableColumn<ProductFx, String> kcalColumn;

    @FXML
    private TableColumn<ProductFx, String> proteinColumn;

    @FXML
    private TableColumn<ProductFx, String> carbColumn;

    @FXML
    private TableColumn<ProductFx, String> fatColumn;

    @FXML
    private TableColumn<ProductFx, ProductFx> deleteColumn;

    @FXML
    private TableColumn<ProductFx, ProductFx> editColumn;



    private ProductsListModel productsListModel;

    @FXML
    void initialize() {
        this.productsListModel = new ProductsListModel();
        try {
            this.productsListModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.categoryComboBox.setItems(this.productsListModel.getCategoryFxObservableList());

        this.productsListModel.categoryFxObjectPropertyProperty().bind(this.categoryComboBox.valueProperty());

        this.productsTableView.setItems(this.productsListModel.getProductFxObservableList());
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryFxProperty());
        this.kcalColumn.setCellValueFactory(cellData -> cellData.getValue().kcalProperty());
        this.proteinColumn.setCellValueFactory(cellData -> cellData.getValue().proteinProperty());
        this.carbColumn.setCellValueFactory(cellData -> cellData.getValue().carbProperty());
        this.fatColumn.setCellValueFactory(cellData -> cellData.getValue().fatProperty());
        this.deleteColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
        this.editColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

        this.deleteColumn.setCellFactory(param -> new TableCell<ProductFx, ProductFx>(){

            Button button = createButton("/icons/delete_icon.png");
            @Override
            protected void updateItem(ProductFx item, boolean empty) {
                super.updateItem(item, empty);

                if(empty) {
                    setGraphic(null);
                    return;
                }

                if(!empty) {
                setGraphic(button);
                button.setOnAction(event -> {
                    try {
                        productsListModel.deleteProduct(item);
                    } catch (ApplicationException e) {
                        DialogsUtils.errorDialog(e.getMessage());

                    }
                });
                }
            }
        });

        this.editColumn.setCellFactory(param -> new TableCell<ProductFx, ProductFx>(){

            Button button = createButton("/icons/edit_icon.png");
            @Override
            protected void updateItem(ProductFx item, boolean empty) {
                super.updateItem(item, empty);

                if(empty) {
                    setGraphic(null);
                    return;
                }

                if(!empty) {
                    setGraphic(button);
                    button.setOnAction(event -> {
                        FXMLLoader loader = FxmlUtils.getLoader("/fxml/AddProduct.fxml");
                        Scene scene = null;
                        try {
                            scene = new Scene(loader.load());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        ProductController controller = loader.getController();
                        controller.getProductModel().setProductFxObjectProperty(item);
                        controller.bindings();
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.showAndWait();
                    });
                }
            }
        });
    }

    private Button createButton(String path) {
        Button button = new Button();
        Image image = new Image(String.valueOf(this.getClass().getResource(path)));
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        return button;
    }

    public void filterOnActionComboBox() {
        this.productsListModel.filterProductList();
    }

    public void clearCategoryComboBox() {
        this.categoryComboBox.getSelectionModel().clearSelection();
    }
}
