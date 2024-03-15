package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.TransactionBo;
import lk.ijse.dao.custom.BookDao;
import lk.ijse.dao.custom.TransactionDao;
import lk.ijse.dao.custom.UserDao;
import lk.ijse.dao.custom.impl.BookDaoImpl;
import lk.ijse.dao.custom.impl.TransactionDaoImpl;
import lk.ijse.dao.custom.impl.UserDaoImpl;
import lk.ijse.dto.TransactionDto;
import lk.ijse.entity.Book;
import lk.ijse.entity.Transaction;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TransactionBoImpl implements TransactionBo {
    private TransactionDao transactionDao = new TransactionDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void save(TransactionDto dto) throws SQLException {
        User user = userDao.getbyId(dto.getUserId());
        Book book = bookDao.getBook(dto.getBookname());
        LocalDateTime borrowedDate = dto.getBorrowed();
        LocalDateTime dueDate = borrowedDate.plusDays(14);
        transactionDao.save(new Transaction(user,book,dto.getBorrowed(),dto.getReturn(),dueDate));

    }
}
