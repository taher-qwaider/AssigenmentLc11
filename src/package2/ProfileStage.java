/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class ProfileStage extends Stage{

    public ProfileStage() throws Exception {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("profile.fxml"));
        loader.setController(this);
        Parent parent=loader.load();
        Scene scene=new Scene(parent, 600, 300);
        setScene(scene);
        setTitle("Profile View");
        
    }
    
    
}
