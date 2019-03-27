package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    public String fileName;
    @FXML
    private TableView<StudentRecord> tbl_grades;
    @FXML
    private TableColumn<StudentRecord, String> col_SID;
    @FXML
    private TableColumn<StudentRecord, Float> col_assignments;
    @FXML
    private TableColumn<StudentRecord, Float> col_midterms;
    @FXML
    private TableColumn<StudentRecord, Float> col_finals;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField txtSID;
    @FXML
    private TextField txtAssignment;
    @FXML
    private TextField txtFinal;
    @FXML
    private TextField txtMidterm;
    private DataSource ds = new DataSource();

    boolean initial = true;

    public void save() {
    }

    private void setCols() {

        if (initial){
            col_SID.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("sid"));
            col_assignments.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("assignments"));
            col_midterms.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("midterm"));
            col_finals.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("finals"));
        }

        if (initial) {
            tbl_grades.getItems().setAll(ds.getAllMarks());
            initial = false;
        }
    }

    public void initialize() {

        setCols();

        btnAdd.setOnAction(e ->
        {
            tbl_grades.getItems().clear();
            setCols();
            ds.add(txtSID.getText(), Float.parseFloat(txtAssignment.getText()), Float.parseFloat(txtMidterm.getText()), Float.parseFloat(txtFinal.getText()));
           // tbl_grades.getItems().set
            tbl_grades.getItems().setAll(ds.getAllMarks());
        });

    }


}
