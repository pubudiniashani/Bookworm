package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import lk.ijse.bo.custom.BookBo;
import lk.ijse.bo.custom.TransactionBo;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.bo.custom.impl.BookBoImpl;
import lk.ijse.bo.custom.impl.TransactionBoImpl;
import lk.ijse.bo.custom.impl.UserBoImpl;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.TransactionDto;
import lk.ijse.entity.Book;
import lk.ijse.tm.BookTm;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class UserdashboardFormController {

    public TableView<BookTm> tblBook;
    public TableColumn colTitle;
    public TableColumn colAuthor;
    public TableColumn colGenre;
    public TableColumn colAvailability;

    public Button btnBorrow;

    public TextField txtSearchBook;
    public TextField txtTitle;
    public TextField txtCategory;
    public TextField txtAuthor;
    public TextField txtAvailability;
    public Button btnUser;
    public TextField txtUserId;

    private BookBo bookBo = new BookBoImpl();

    private UserBo userBo = new UserBoImpl();

    private TransactionBo transactionBo = new TransactionBoImpl();


    public void initialize(){
        setCellValueFactory();
        setTableValue();

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

    public void btnBorrowOnAction(ActionEvent actionEvent) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String title = txtTitle.getText();

        if(title != null){
            TransactionDto dto = new TransactionDto();
            dto.setBookname(txtTitle.getText());
            dto.setBorrowed(LocalDateTime.now());
            dto.setReturn(false);
            dto.setUserId(Integer.parseInt(txtUserId.getText()));
            try {
                transactionBo.save(dto);
                BookDto bookDto = bookBo.getBook(txtTitle.getText());
                bookDto.setAvailability("no");
                bookBo.updateBook(bookDto);
                new Alert(Alert.AlertType.CONFIRMATION,"book borrowed").show();
                System.out.println("ok");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        //boolean isUpdated = bookBo.
        
    }

    private void updateBookAvailability(Book book){
        if(book!= null){
            book.setAvailability("no");
            bookBo.updateBook(book);
        }
    }


    public void txtSearchOnAction(ActionEvent actionEvent) {
           String searchbook = txtSearchBook.getText();

        try {
           BookDto dto = bookBo.getBook(searchbook);

            txtTitle.setText(dto.getTitle());
            txtAuthor.setText(dto.getAuthor());
            txtCategory.setText(dto.getCategory());
            txtAvailability.setText(dto.getAvailability());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnUserOnAction(ActionEvent actionEvent) {

    }
}
