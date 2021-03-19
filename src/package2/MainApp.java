/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class MainApp extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(getClass().getResource("loginScreen.fxml"));
        FXMLLoader loader=new FXMLLoader(MainApp.class.getResource("loginScreen.fxml"));
        FlowPane parent=loader.load();
        //getClass().getResource("MainScreen.fxml")
        Scene scene=new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main App");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
