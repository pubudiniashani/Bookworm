package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.custom.BookBo;
import lk.ijse.bo.custom.BranchBo;
import lk.ijse.bo.custom.impl.BookBoImpl;
import lk.ijse.bo.custom.impl.BranchBoImpl;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.BranchDto;
import lk.ijse.entity.Book;
import lk.ijse.tm.BookTm;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class BookFormController {
    public AnchorPane root;
    public ComboBox<Integer> cmbBranch;
    public TextField txtAvailability;
    public TextField txtTitle;
    public TextField txtAuthor;
    public TextField txtGenre;
    public TableView<BookTm> tblBook;
    public TableColumn colTitle;
    public TableColumn colAuthor;
    public TableColumn colGenre;
    public TableColumn colAvailability;
    public Button btnSave;
    public Button btnDelete;
    public Button btnUpdate;
    private String bookName;

    private int bookId;

    private BookBo bookBo = new BookBoImpl();

    private BranchBo branchBo = new BranchBoImpl();

    public void initialize(){
        setCellValueFactory();
        setTableValue();
        tableListner();
        setComboValue();
    }

    private void setComboValue() {

        ObservableList<Integer> list = FXCollections.observableArrayList();

        try {
            List<BranchDto>  branchDtos = branchBo.getAllBranches();
            for (BranchDto dto:branchDtos) {
                list.add(dto.getBranchId());
            }
            System.out.println(branchDtos);
            cmbBranch.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void tableListner() {
        tblBook.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(BookTm newValue) {
        txtTitle.setText(newValue.getTitle());
        txtAuthor.setText(newValue.getAuthor());
        txtGenre.setText(newValue.getCategory());
        txtAvailability.setText(newValue.getAvailability());
        bookName= newValue.getTitle();
        try {
            BookDto bookDto = bookBo.getBook(bookName);
            bookId=bookDto.getBookId();
            cmbBranch.setValue(bookDto.getBranchId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void setTableValue() {
        ObservableList<BookTm> observableList = FXCollections.observableArrayList();

        try {
            List<BookDto> bookDtoList = bookBo.getAllBooks();
            for (BookDto dto: bookDtoList) {
                observableList.add(new BookTm(dto.getTitle(), dto.getAuthor(), dto.getCategory(), dto.getAvailability()));

            }
            tblBook.getItems().clear();
            tblBook.setItems(observableList);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("category"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        var dto = new BookDto(txtTitle.getText(),txtAuthor.getText(),txtGenre.getText(), txtAvailability.getText(),cmbBranch.getValue());

        try {
            bookBo.saveBook(dto);
            tblBook.refresh();
            System.out.println(dto);
            new Alert(Alert.AlertType.CONFIRMATION,"book saved").show();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {


        try {
            BookDto bookDto = bookBo.getBook(bookName);
            bookDto.setAuthor(txtAuthor.getText());
            bookDto.setAvailability(txtAvailability.getText());
            bookDto.setBranchId(cmbBranch.getValue());
            bookDto.setCategory(txtGenre.getText());
            bookDto.setTitle(txtTitle.getText());
            bookBo.updateBook(bookDto);
            tblBook.refresh();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            bookBo.deleteBook(bookId);
            tblBook.refresh();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateBook(){

        boolean matches = Pattern.matches("^[A-Za-z\\s]+$", txtTitle.getText());
        if (!matches) {
            new Alert(Alert.AlertType.ERROR, "Invalid title").show();
            return false;
        }

        boolean matches1 = Pattern.matches("^[A-Za-z\\s]{3,}$",txtAuthor.getText());
        if(!matches1){
            new Alert(Alert.AlertType.ERROR,"Invalid author").show();
        }

        boolean matches2 = Pattern.matches("^[A-Za-z\\s]{3,}$",txtGenre.getText());
        if(!matches2){
            new Alert(Alert.AlertType.ERROR,"Invalid genre").show();
            return false;
        }


        return true;
    }

}
