package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserloginFormController {

    public AnchorPane root;
    public TextField txtEmail;
    public TextField txtPassword;

    public void btnRegOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        String email = txtEmail.getText();
        String pw = txtPassword.getText();




        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/userdashboard_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User Dashboard");
        stage.centerOnScreen();
    }
}
