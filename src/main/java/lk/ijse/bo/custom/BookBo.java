package lk.ijse.bo.custom;

import lk.ijse.dto.BookDto;
import lk.ijse.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookBo {

    void saveBook(BookDto dto) throws SQLException;

    void updateBook(BookDto dto) throws SQLException;

    void deleteBook(int bookId) throws SQLException;

    BookDto getBook(String text) throws SQLException;
    List<BookDto> getAllBooks() throws SQLException;

    void updateBook(Book book);
}
