package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDao;
import lk.ijse.entity.Book;

public interface BookDao extends CrudDao<Book> {
    Book getBook(String text);
}
