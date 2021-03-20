/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class MainScreenController implements Initializable {

    @FXML
    private MenuItem open;
    @FXML
    private MenuItem close;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem about;
    @FXML
    private ComboBox<String> pages;
    @FXML
    private WebView webView;
    @FXML
    private TextArea textArea;
    @FXML
    private Slider slider;
    
    private File openingFile;
    @FXML
    private RadioMenuItem red;
    @FXML
    private RadioMenuItem cyan;
    @FXML
    private RadioMenuItem gold;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pages.getItems().addAll("JavaFX", "GitHub Repository", "GitHub Profile");
        slider.valueProperty().addListener(e-> {
            textArea.setStyle("-fx-font-size:" + slider.getValue() +"pt");
        });
        ToggleGroup radioItems=new ToggleGroup();
        red.setToggleGroup(radioItems);
        cyan.setToggleGroup(radioItems);
        gold.setToggleGroup(radioItems);
    }    

    @FXML
    private void OpenAction(ActionEvent event) {
        FileChooser fileChooser=new FileChooser();
            fileChooser.setInitialDirectory(new File("src/javafxapplication6"));
            openingFile=fileChooser.showOpenDialog(open.getParentPopup().getScene().getWindow());
            try{
                Scanner s=new Scanner(openingFile);
                while(s.hasNextLine()){
                    textArea.appendText(s.nextLine() + "\n");
                }
                s.close();
            }catch(FileNotFoundException ex){
                
            }
    }

    @FXML
    private void CloseAction(ActionEvent event) {
        textArea.setText("");
    }

    @FXML
    private void SaveAction(ActionEvent event) {
        try{
            String[] data=textArea.getText().split("\\r?\\n");
            PrintWriter pr=new PrintWriter(openingFile);
            for(String line:data){
                pr.println(line);
            }
            pr.close();
            }catch(FileNotFoundException ex){
                System.err.println(ex.getMessage());
            }
    }

    @FXML
    private void ExitAction(ActionEvent event) {
        Stage stage =(Stage)((MenuItem) event.getSource()).getParentPopup().getScene().getWindow();
        stage.close();
    }

    @FXML
    private void AboutAction(ActionEvent event) throws Exception {
        
        new ProfileStage().show();
    }

    @FXML
    private void comboAction(ActionEvent event) {
        if(pages.getSelectionModel().getSelectedItem().equals("JavaFX")){
            webView.getEngine().load("https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html");
        }else if(pages.getSelectionModel().getSelectedItem().equals("GitHub Profile")){
            webView.getEngine().load("https://github.com/taher-qwaider");
        }else if(pages.getSelectionModel().getSelectedItem().equals("GitHub Repository")){
            webView.getEngine().load("https://github.com/taher-qwaider/AssigenmentLc11");
        }
    }

    @FXML
    private void redColorAction(ActionEvent event) {
        textArea.setStyle("-fx-text-fill:red;-fx-font-size:"+slider.getValue()+"pt");
    }

    @FXML
    private void cyanColorAction(ActionEvent event) {
        textArea.setStyle("-fx-text-fill:cyan;-fx-font-size:"+slider.getValue()+"pt");
    }

    @FXML
    private void goldColorAction(ActionEvent event) {
        textArea.setStyle("-fx-text-fill:gold;-fx-font-size:"+slider.getValue()+"pt");
    }

    @FXML
    private void sliderAction(MouseEvent event) {
    }
    
}
