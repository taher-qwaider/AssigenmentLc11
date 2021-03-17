/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class ProfileStage extends Stage{

    public ProfileStage() {
        Label name=new Label("Name :");
        name.setPadding(new Insets(.5, .5, .5, .5));
        Label nameLabel =new Label("Taher Qwaider");
        nameLabel.setPadding(new Insets(.5, .5, .5, .5));
        HBox hbox1=new HBox(name, nameLabel);
        
        Label spec=new Label("Specialty :");
        spec.setPadding(new Insets(.5, .5, .5, .5));
        Label specLabel =new Label("Software Development");
        specLabel.setPadding(new Insets(.5, .5, .5, .5));
        HBox hbox4=new HBox(spec, specLabel);
        
        Label depa=new Label("Level :");
        depa.setPadding(new Insets(.5, .5, .5, .5));
        Label depaLabel =new Label("3");
        depaLabel.setPadding(new Insets(.5, .5, .5, .5));
        HBox hbox5=new HBox(depa, depaLabel);
        
        Label github=new Label("ID :");
        github.setPadding(new Insets(.5, .5, .5, .5));
        Label githubLabel =new Label("120190804");
        githubLabel.setPadding(new Insets(.5, .5, .5, .5));
        HBox hbox2=new HBox(github, githubLabel);
        
        Label course =new Label("Course Name :");
        course.setPadding(new Insets(.5, .5, .5, .5));
        Label courseLabel =new Label("Programming 3");
        courseLabel.setPadding(new Insets(.5, .5, .5, .5));
        HBox hbox3=new HBox(course, courseLabel);
        
        VBox vbox=new VBox(10, hbox1, hbox2, hbox3, hbox4, hbox5);
        FlowPane flowPane=new FlowPane(vbox);
        flowPane.setAlignment(Pos.CENTER);
        Scene scene=new Scene(flowPane, 600, 300);
        scene.getStylesheets().add("file:src/javafxapplication6/ProfileStyle.css");
        setScene(scene);
        setTitle("My Profile");
    }
    
    
}
