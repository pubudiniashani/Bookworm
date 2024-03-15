package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.TransactionDao;
import lk.ijse.entity.Transaction;
import org.hibernate.Session;

import java.sql.SQLException;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public void save(Transaction transaction) throws SQLException {

        Session session = FactoryConfiguration.getInstance().getSession();

        session.save(transaction);

        session.close();
    }
}
