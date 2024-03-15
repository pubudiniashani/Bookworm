package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.BookDao;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {

    @Override
    public void save(Book entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(Book entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

    }

    @Override
    public void delete(int id) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Book entity = getbyId(id);
        session.delete(entity);

        /*Book entity = null;

        try {
            entity = getbyId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.delete(entity);*/

        transaction.commit();
        session.close();
    }

    @Override
    public List<Book> loadAll() throws SQLException {
        List<Book> books = null;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Book");
        books = query.getResultList();

        transaction.commit();
        return books;

    }

    @Override
    public Book getbyId(int id) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Book book= session.get(Book.class,id);

        transaction.commit();
        session.close();

        return book;
    }

    @Override
    public Book getBook(String text) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Book book = null;
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Book where title=:bookName");
        query.setParameter("bookName", text);
        List<Book> books= query.getResultList();
        for (Book entity : books){
            book = entity;
        }
        transaction.commit();
        return book;
    }
}
