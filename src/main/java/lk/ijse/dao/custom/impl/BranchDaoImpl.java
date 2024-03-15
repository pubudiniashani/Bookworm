package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.dao.custom.BranchDao;
import lk.ijse.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BranchDaoImpl implements BranchDao {



    @Override
    public void save(Branch entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(Branch entity) throws SQLException {
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

        Branch  entity = getbyId(id);
        session.delete(entity);

        transaction.commit();
        session.close();

    }

    @Override
    public List<Branch> loadAll() throws SQLException {
        List<Branch> branches = null;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Branch ");
       branches = query.getResultList();
        transaction.commit();
        return branches;
    }

    @Override
    public Branch getbyId(int id) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Branch branch= session.get(Branch.class,id);

        transaction.commit();
        session.close();

        return branch;
    }

    @Override
    public Branch get(String data) throws SQLException {
       /* return executeTransaction(session -> {
            Query query = session.createQuery("from Branch where branchName=:branchName");
            query.setParameter("branchName", data);
            List<Branch> branches= query.getResultList();
            for (Branch branch : branches){
                return branch;
            }
            System.out.println("ok");
            return null;
        });*/
        Session session = FactoryConfiguration.getInstance().getSession();
        Branch branch = null;
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Branch where branchName=:branchName");
        query.setParameter("branchName", data);
        List<Branch> branches= query.getResultList();
        for (Branch entity : branches){
            branch = entity;
        }
        transaction.commit();
       return branch;
    }
}
