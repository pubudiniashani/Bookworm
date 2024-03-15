package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.custom.AdminBo;
import lk.ijse.bo.custom.impl.AdminBoImpl;
import lk.ijse.dto.AdminDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class SignupFormController {

    public TextField txtEmail;
    public TextField txtPassword;

    public AnchorPane root;
    public TextField txtName;
    public TextField txtUsername;

    private AdminBo adminBo = new AdminBoImpl();


    public void btnCreateOnAction(ActionEvent actionEvent) throws IOException {

        boolean isValidate = validateAdmin();
        if(isValidate) {

            try {
                adminBo.saveAdmin(new AdminDto(txtName.getText(), txtEmail.getText(), txtUsername.getText(),
                        txtPassword.getText()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/adminlogin_form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Admin Form");
            stage.centerOnScreen();

        }
    }

    private boolean validateAdmin(){

        boolean matches = Pattern.matches("[A-Za-z]{4,}",txtName.getText());
        if(!matches){
            new Alert(Alert.AlertType.ERROR,"Invalid name").show();
            return false;
        }

        boolean matches1 = Pattern.matches("[A-Za-z]{4,}",txtUsername.getText());
        if(!matches1){
            new Alert(Alert.AlertType.ERROR,"Invalid user name").show();
            return false;
        }

        boolean matches2 = Pattern.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z]+\\.[a-zA-Z]+$", txtEmail.getText());
        if(!matches2){
            new Alert(Alert.AlertType.ERROR,"Invalid email").show();
            return false;
        }

       /* boolean matches3 = Pattern.matches("^[0-9][a-zA-Z0-9]{3,}$\n",txtPassword.getText());
        if(!matches3){
            new Alert(Alert.AlertType.ERROR,"Invalid password").show();
            return false;
        }*/

        return true;

    }
}
