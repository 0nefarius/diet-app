package pl.dietap.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pl.dietap.modelfx.CategoryFx;
import pl.dietap.modelfx.CategoryModel;
import pl.dietap.utils.DialogsUtils;
import pl.dietap.utils.exceptions.ApplicationException;

public class CategoryController {

    @FXML
    private Button addCategoryButton;

    @FXML
    private Button deleteCategoryButton;

    @FXML
    private Button editCategoryButton;

    @FXML
    private TextField categoryTextField;

    @FXML
    private ComboBox<CategoryFx> categoryComboBox;

    @FXML
    private TreeView<String> categoryTreeView;

    @FXML
    private CategoryModel categoryModel;

    @FXML
    public void initialize() throws ApplicationException {
        this.categoryModel = new CategoryModel();
        try {
            this.categoryModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.categoryComboBox.setItems(this.categoryModel.getCategoryList());
        this.categoryTreeView.setRoot(this.categoryModel.getRoot());
        initBindings();
    }

    private void initBindings() {
        this.addCategoryButton.disableProperty().bind(categoryTextField.textProperty().isEmpty());
        this.deleteCategoryButton.disableProperty().bind(this.categoryModel.categoryProperty().isNull());
        this.editCategoryButton.disableProperty().bind(this.categoryModel.categoryProperty().isNull());
    }

    public void addCategoryOnAction() throws ApplicationException {
        try {
            categoryModel.saveCategoryInDataBase(categoryTextField.getText());
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        categoryTextField.clear();
    }

    public void onActionDeleteButton() throws ApplicationException {
        this.categoryModel.deleteCategoyById();
    }

    public void onActionComboBox() {
        this.categoryModel.setCategory(this.categoryComboBox.getSelectionModel().getSelectedItem());
    }

    public void onActionEditCategory() throws ApplicationException {
        String newCategoryName = DialogsUtils.editDialog(this.categoryModel.getCategory().getName());
        if(newCategoryName!=null) {
            this.categoryModel.getCategory().setName(newCategoryName);
            this.categoryModel.updateCategoryInDataBase();
            try {
                this.categoryModel.updateCategoryInDataBase();
            } catch (ApplicationException e) {
                e.printStackTrace();
            }
        }
    }
}
