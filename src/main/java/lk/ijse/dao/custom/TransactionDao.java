package lk.ijse.dao.custom;

import lk.ijse.entity.Transaction;

import java.sql.SQLException;

public interface TransactionDao {

    void save(Transaction transaction) throws SQLException;
}
