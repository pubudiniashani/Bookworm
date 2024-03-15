package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.custom.AdminBo;
import lk.ijse.bo.custom.BranchBo;
import lk.ijse.bo.custom.impl.AdminBoImpl;
import lk.ijse.bo.custom.impl.BranchBoImpl;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.BranchDto;
import lk.ijse.entity.Branch;
import lk.ijse.tm.BranchTm;

import java.sql.SQLException;
import java.util.List;

public class BranchFormController {
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContactNumber;
    public TableView<BranchTm> tblBranch;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colAdmin;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;
    public ComboBox<Integer> cmbAdminId;
    private int branchId;
    private String branchName;

    private BranchBo branchBo = new BranchBoImpl();

    private AdminBo adminBo = new AdminBoImpl();

    public void initialize(){
        setCellValueFactory();
        setTableValue();
        tableListner();
        setComboValue();
    }

    private void setComboValue() {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        try {
            List<AdminDto> adminDtos = adminBo.getAllAdmins();
            for (AdminDto dto : adminDtos){
                list.add(dto.getAdminId());
            }
         cmbAdminId.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void setCellValueFactory() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAdmin.setCellValueFactory(new PropertyValueFactory<>("adminName"));
    }

    private void tableListner() {
        tblBranch.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
            });

    }

   private void setData(BranchTm newValue){
        txtName.setText(newValue.getName());
        txtAddress.setText(newValue.getAddress());
        txtContactNumber.setText(newValue.getContact());
        cmbAdminId.setValue(Integer.valueOf(newValue.getAdminName()));

       try {
           BranchDto branchDto = branchBo.getBranch(newValue.getName());
           branchId= branchDto.getBranchId();
           branchName= newValue.getName();

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

    private void setTableValue() {
        ObservableList<BranchTm> observableList = FXCollections.observableArrayList();

        try {
            List<BranchDto> branchDtoList = branchBo.getAllBranches();

            for (BranchDto dto : branchDtoList){
                 String id = String.valueOf(dto.getAdminId());
                observableList.add(new BranchTm(dto.getBranchName(), dto.getContact(), dto.getAddress(),id));
            }
            tblBranch.getItems().clear();
            tblBranch.setItems(observableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void btnSaveOnAction(ActionEvent actionEvent) {

        var dto = new BranchDto(txtName.getText(),txtContactNumber.getText(),txtAddress.getText(),cmbAdminId.getValue());

        try {
            branchBo.saveBranch(dto);
            new Alert(Alert.AlertType.CONFIRMATION,"Branch saved").show();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {


        try {
            BranchDto dto = branchBo.getBranch(branchName);
            dto.setAddress(txtAddress.getText());
            dto.setAdminId(cmbAdminId.getValue());
            dto.setBranchName(txtName.getText());
            dto.setContact(txtContactNumber.getText());
          /*  var dto = new BranchDto(txtName.getText(),txtContactNumber.getText(),txtAddress.getText(),cmbAdminId.getValue());*/
            branchBo.updateBranch(dto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            branchBo.deleteBranch(branchId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
