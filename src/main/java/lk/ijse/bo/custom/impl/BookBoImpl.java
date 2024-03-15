package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BookBo;
import lk.ijse.dao.custom.BookDao;
import lk.ijse.dao.custom.BranchDao;
import lk.ijse.dao.custom.impl.BookDaoImpl;
import lk.ijse.dao.custom.impl.BranchDaoImpl;
import lk.ijse.dto.BookDto;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBoImpl implements BookBo {

    private BookDao bookDao = new BookDaoImpl();

    private BranchDao branchDao = new BranchDaoImpl();
    @Override
    public void saveBook(BookDto dto) throws SQLException {
        Branch branch = branchDao.getbyId(dto.getBranchId());
        bookDao.save(new Book(dto.getTitle(), dto.getAuthor(), dto.getCategory(), dto.getAvailability(), branch));
    }

    @Override
    public void updateBook(BookDto dto) throws SQLException {
        Branch branch = branchDao.getbyId(dto.getBranchId());
        bookDao.update(new Book(dto.getBookId(), dto.getTitle(), dto.getAuthor(), dto.getCategory(),
                dto.getAvailability(), branch));

    }

    @Override
    public void deleteBook(int bookId) throws SQLException {
        bookDao.delete(bookId);
    }

    @Override
    public BookDto getBook(String text) throws SQLException {
     Book book =   bookDao.getBook(text);
     return new BookDto(book.getBookId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getAvailability(), book.getBranchId().getBranchId());
    }

    @Override
    public List<BookDto> getAllBooks() throws SQLException {

        List<Book> books = bookDao.loadAll();
        List<BookDto> dtos = new ArrayList<>();

        for (Book book: books) {
            dtos.add(new BookDto(book.getBookId(),book.getTitle(),book.getAuthor()
                    ,book.getCategory(),book.getAvailability(),book.getBranchId().getBranchId()));
        }
        System.out.println(dtos);
        return dtos;

    }

    @Override
    public void updateBook(Book book) {

    }
}
