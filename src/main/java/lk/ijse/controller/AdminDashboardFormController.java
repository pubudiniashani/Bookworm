package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardFormController {
    public AnchorPane root;

    public void btnBooksOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/book_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    public void btnBranchesOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/branch_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    public void btnTransactionOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/transaction_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/admin_dashboard_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
