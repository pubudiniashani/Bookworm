package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDao;
import lk.ijse.entity.Branch;

import java.sql.SQLException;

public interface BranchDao extends CrudDao<Branch> {


    Branch get(String name) throws SQLException;
}
