/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class JavaFXApplication6 extends Application {
    private Label loginLable;
    private Label messageLabel;
    private TextField userName;
    private PasswordField password;
    private Button submit, chancle;
    @Override
    public void start(Stage primaryStage) {
        loginLable = new Label("Login Information");
        messageLabel = new Label("Initial Text");
        
        userName=new TextField();
        userName.setPromptText("Enter User Name");
        
        password=new PasswordField();
        password.setPromptText("Enter Password");
        
        VBox v=new VBox(10, loginLable, messageLabel, userName, password);
        v.setAlignment(Pos.CENTER);
        v.setStyle("-fx-border-color: green");
        v.setPadding(new Insets(5, 20, 30, 20));
        
        
        submit=new Button("Submit");
        submit.getStyleClass().add("button-submit");
        
        chancle=new Button("Cancle");
        chancle.getStyleClass().add("button-cancle");
        
        HBox h=new HBox();
        h.getChildren().addAll(submit, chancle);
        h.setSpacing(20);
        h.setStyle("-fx-border-color: navy");
        h.setAlignment(Pos.CENTER);
        
        VBox main=new VBox(10, v, h);
        main.setStyle("-fx-border-color: red");
        FlowPane flowPane = new FlowPane(main);
        flowPane.setAlignment(Pos.CENTER);
        
        
        submit.setOnAction(new SubmitAction()); 
        chancle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        Scene scene=new Scene(flowPane, 600, 400);
        scene.getStylesheets().add("file:src/javafxapplication6/style.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("First Application");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private class SubmitAction implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            try{
                Scanner s=new Scanner(new File("src/javafxapplication6/passwords.txt"));
                while(s.hasNextLine()){
                    String[] text=s.nextLine().split(" ");
                    if (text[0].equals(userName.getText()) && text[1].equals(password.getText())){
                        messageLabel.getStyleClass().clear();
                        messageLabel.getStyleClass().add("message-true");
                        messageLabel.setText("Valid inputs");
                        new MainScreen().show();
                        break;
                    }else{
                        messageLabel.setText("Invalid inputs");
                        messageLabel.getStyleClass().clear();
                        messageLabel.getStyleClass().add("message-false");
                    }
                }
                s.close();
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
                messageLabel.setText("Error in reading password file");
                messageLabel.getStyleClass().clear();
                messageLabel.getStyleClass().add("message-false");
            }
        }
        
    }
    
}
