/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package2;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class MainScreenClass extends Stage{

    public MainScreenClass() throws IOException{
        System.out.println(getClass().getResource("MainScreen.fxml"));
        FXMLLoader loader=new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        BorderPane parent=loader.load();
        
        Scene scene=new Scene(parent, 1000, 600);
        
        setScene(scene);
        setTitle("Main Screen");
        show();
    }
    
}
