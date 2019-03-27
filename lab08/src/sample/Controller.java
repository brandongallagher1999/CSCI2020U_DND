package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class Controller {


    File file = new File("current.csv");


    @FXML
    TextField txt_SID;
    @FXML
    TextField txt_midterm;
    @FXML
    TextField txt_final;
    @FXML
    TextField txt_assignment;
    //buttons
    @FXML
    MenuItem menu_new;
    @FXML
    MenuItem menu_save;
    @FXML
    MenuItem menu_saveAs;
    @FXML
    Button btn_add;
    @FXML
    MenuItem menu_open;
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



    public void open() throws Exception
    {

        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV Files files (*.csv)", "*.csv");
        chooser.getExtensionFilters().add(extFilter);

        file = chooser.showSaveDialog(Main.getPrimaryStage());


        Scanner scanner = new Scanner(file);

        //String sid, Float assignments, Float midterm, Float finals
        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            DataSource.addMark(values[0], Float.parseFloat(values[1]), Float.parseFloat(values[2]), Float.parseFloat(values[3]));
            setCols();
        }

    }

    public void exit()
    {
        Main.getPrimaryStage().close();
    }


    private void setCols() {
        col_SID.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("sid"));
        col_assignments.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("assignments"));
        col_midterms.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("midterm"));
        col_finals.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("finals"));

        tbl_grades.getItems().setAll(DataSource.getAllMarks());
    }


    public void saveAs() {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        chooser.getExtensionFilters().add(extFilter);

        file = chooser.showSaveDialog(Main.getPrimaryStage());

        save();
    }


    public void save() {
        try {
            FileWriter writer = new FileWriter(file, true);
            ObservableList<StudentRecord> marks = DataSource.getAllMarks();

            for (StudentRecord mark : marks) {
                writer.write(mark.getSid() + "," + mark.getAssignments() + "," + mark.getMidterm() + "," + mark.getFinals());
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void test() {

        tbl_grades.getItems().addAll(DataSource.addMark(txt_SID.getText(), Float.parseFloat(txt_assignment.getText()), Float.parseFloat(txt_midterm.getText()), Float.parseFloat(txt_final.getText())));
    }

    public void initialize() {
        setCols();


    }

}
