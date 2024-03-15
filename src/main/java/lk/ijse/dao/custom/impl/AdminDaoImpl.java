package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    @Override
    public void save(Admin entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(Admin entity) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public List<Admin> loadAll() throws SQLException {
        List<Admin> admins = new ArrayList<>();

        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();

            // HQL query to retrieve all admins
            String hql = "FROM Admin";
            Query<Admin> query = session.createQuery(hql, Admin.class);
            admins = query.getResultList();

            System.out.println(admins);

            transaction.commit();
        } catch (Exception e) {
            // Handle exceptions appropriately (e.g., log, throw, etc.)
            e.printStackTrace();
        }

        // The session is automatically closed due to try-with-resources.

        return admins;
    }

    @Override
    public Admin getbyId(int id) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Admin admin = session.get(Admin.class,id);

        transaction.commit();
        session.close();

        return admin;
    }

}
