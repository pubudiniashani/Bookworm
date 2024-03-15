package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.bo.custom.impl.UserBoImpl;
import lk.ijse.dto.UserDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserFormController {
    public Button btnRegister;
    public AnchorPane root;
    public Button btnBack;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtPw;

    private UserBo userBo = new UserBoImpl();

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {

        boolean isValidate = validateUser();

        if (isValidate) {

            if (txtEmail.getText() != null && txtName.getText() != null && txtPw.getText() != null) {
                var dto = new UserDto(txtName.getText(), txtPw.getText(), txtEmail.getText());
                try {
                    userBo.saveUser(dto);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/userlogin_form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("User Dashboard");
            stage.centerOnScreen();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/userlogin_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }

    private boolean validateUser(){

        boolean matches = Pattern.matches("[A-Za-z]{4,}",txtName.getText());
        if(!matches){
            new Alert(Alert.AlertType.ERROR,"Invalid user name").show();
            return false;
        }

        boolean matches1 = Pattern.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z]+\\.[a-zA-Z]+$",txtEmail.getText());
        if(!matches1){
            new Alert(Alert.AlertType.ERROR,"Invalid email").show();
            return false;
        }

        /*boolean matches2 = Pattern.matches("^[a-zA-Z0-9][^\\s]{3,}$\n",txtPw.getText());
        if(!matches2){
            new Alert(Alert.AlertType.ERROR,"Invalid password").show();
            return false;
        }*/


        return true;
    }
}
