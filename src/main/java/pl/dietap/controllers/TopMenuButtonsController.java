package pl.dietap.controllers;

import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String OPEN_PRODUCT_LIST_FXML = "/fxml/OpenProductList.fxml";
    public static final String ADD_PRODUCT_FXML = "/fxml/AddProduct.fxml";
    public static final String ADD_CATEGORY_FXML = "/fxml/AddCategory.fxml";
    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

    @FXML
    public void openProductList() {
        mainController.setCenter(OPEN_PRODUCT_LIST_FXML);
    }

    @FXML
    public void addProduct() {
        resetToggleButtons();

        mainController.setCenter(ADD_PRODUCT_FXML);
    }

    @FXML
    public void addCategory() {
        resetToggleButtons();

        mainController.setCenter(ADD_CATEGORY_FXML);
    }

    private void resetToggleButtons() {
        if(toggleButtons.getSelectedToggle()!=null) {
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
