/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class LoginScreenController implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Label messageLabel;
    @FXML
    private Button submit;
    @FXML
    private Button cancle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitAction(ActionEvent event) throws IOException {
        try{
            Scanner s=new Scanner(new File("src/package2/passwords.txt"));
            while(s.hasNextLine()){
                String[] text=s.nextLine().split(" ");
                if (text[0].equals(userName.getText()) && text[1].equals(password.getText())){
                    messageLabel.setStyle("-fx-text-fill:green");
                    messageLabel.setText("Valid inputs");
                    new MainScreenClass().show();
                    break;
                }else{
                    messageLabel.setText("Invalid inputs");
                    messageLabel.setStyle("-fx-text-fill:red");
                }
            }
            s.close();
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
                messageLabel.setText("Error in reading password file");
                messageLabel.setStyle("-fx-text-fill:red");
            }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        System.exit(0);
    }
    
}
