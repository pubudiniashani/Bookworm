package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.custom.AdminBo;
import lk.ijse.bo.custom.impl.AdminBoImpl;
import lk.ijse.dto.AdminDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminloginFormController {
    public AnchorPane root;
    public Button btnBack;
    public Button btnLogin;
    public TextField txtUsername;
    public TextField txtPassword;

    private AdminBo adminBo = new AdminBoImpl();

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please enter both username and password.").show();
            return;
        }

        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/admin_dashboard_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Admin dashboard Form");
        stage.centerOnScreen();

       /* String userName = txtUsername.getText();
        String password = txtPassword.getText();

        try {
            List<AdminDto> adminDtoList = adminBo.getAllAdmins();
            for (AdminDto dto: adminDtoList) {
                if(dto.getUserName().equals(userName) && dto.getPassword().equals(password)){
                    AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/admin_dashboard_form.fxml"));
                    Scene scene = new Scene(anchorPane);
                    Stage stage = (Stage) root.getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Admin dashboard Form");
                    stage.centerOnScreen();
                }else{
                    new Alert(Alert.AlertType.ERROR, "Something is wrong").show();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/


    }

    public void btnSignupOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/signup_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }
}
