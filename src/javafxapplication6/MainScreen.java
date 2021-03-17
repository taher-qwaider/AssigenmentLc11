/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class MainScreen extends Stage{
    private MenuBar menuBar;
    private Menu fileMenu, colorMenu, aboutMenu;
    private MenuItem opene, close, save, exit, aboutItem;
    private RadioMenuItem goldItem, cyanItem, redItem;
    private TextArea textArea;
    private Slider slider;
    private ComboBox<String> pages;
    private WebView webView;
    private File openingFile;
    

    public MainScreen() {
        menuBar =new MenuBar();
        
        fileMenu =new Menu("File");
        colorMenu =new Menu("Color");
        aboutMenu =new Menu("About");
        
        opene =new MenuItem("Open");
        close = new MenuItem("Close");
        save= new MenuItem("Save");
        exit =new MenuItem("Exit");
        fileMenu.getItems().addAll(opene, close, save, exit);

        goldItem =new RadioMenuItem("Gold");
        goldItem.setStyle("-fx-text-fill:gold");
        cyanItem =new RadioMenuItem("Cyan");
        cyanItem.setStyle("-fx-text-fill:cyan");
        redItem =new RadioMenuItem("Red");
        redItem.setStyle("-fx-text-fill:red");
        
        ToggleGroup colors =new ToggleGroup();
        goldItem.setToggleGroup(colors);
        cyanItem.setToggleGroup(colors);
        redItem.setToggleGroup(colors);
        
        colorMenu.getItems().addAll(goldItem, cyanItem, redItem);
        
        aboutItem =new MenuItem("about");
        aboutMenu.getItems().add(aboutItem);
        
        menuBar.getMenus().addAll(fileMenu, colorMenu, aboutMenu);
        
        BorderPane borderPane=new BorderPane();
        borderPane.setTop(menuBar);
        
        textArea =new TextArea("Enter the text Here");
        textArea.setMinHeight(160);
        
        slider =new Slider(5, 35, 12);
        slider.setMajorTickUnit(5);
        slider.setMinorTickCount(4);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setSnapToTicks(true);
        slider.valueProperty().addListener(e-> {
            textArea.setStyle("-fx-font-size:" + slider.getValue() +"pt");
        });
        
        
        pages =new ComboBox<>();
        pages.getItems().addAll("Java FX", "GitHub Profile");
        pages.getSelectionModel().selectFirst();
        pages.setOnAction(e ->{
            if(pages.getSelectionModel().getSelectedItem().equals("Java FX")){
                webView.getEngine().load("https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html");
            }else if(pages.getSelectionModel().getSelectedItem().equals("GitHub Profile")){
                webView.getEngine().load("https://github.com/taher-qwaider");
            }
        });
        
        webView =new WebView();
        webView.getEngine().load("https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html");
        
        HBox hbox1=new HBox(10, pages, webView);

        VBox vbox1=new VBox(15, textArea, slider, hbox1);
        borderPane.setCenter(vbox1);
        
        opene.setOnAction(e -> {
            FileChooser fileChooser=new FileChooser();
            fileChooser.setInitialDirectory(new File("src/javafxapplication6"));
            openingFile=fileChooser.showOpenDialog(this);
            textArea.appendText("\n");
            try{
                Scanner s=new Scanner(openingFile);
                while(s.hasNextLine()){
                    textArea.appendText(s.nextLine() + "\n");
                }
                s.close();
            }catch(FileNotFoundException ex){
                
            }
        });
        save.setOnAction(e ->{
            try{
                String[] data=textArea.getText().split("\\r?\\n");
                PrintWriter pr=new PrintWriter(openingFile);
                for(String line:data){
                    pr.println(line);
                }
                pr.close();
            }catch(FileNotFoundException ex){
                
            }
        });
        close.setOnAction(e-> {
            textArea.setText("");
        });
        exit.setOnAction(e->{
            this.close();
        });
        
        goldItem.setOnAction(e->{
            textArea.setStyle("-fx-text-fill:gold");
        });
        cyanItem.setOnAction(e->{
            textArea.setStyle("-fx-text-fill:cyan");
        });
        redItem.setOnAction(e->{
            textArea.setStyle("-fx-text-fill:red");
        });
        aboutItem.setOnAction(e-> {
            new ProfileStage().show();
        });
        Scene scene =new Scene(borderPane, 1000, 600);
        setScene(scene);
        setTitle("Text Editor");
        
    }
    
    
}
