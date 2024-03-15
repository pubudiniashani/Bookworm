package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BranchBo;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.dao.custom.BranchDao;
import lk.ijse.dao.custom.impl.AdminDaoImpl;
import lk.ijse.dao.custom.impl.BranchDaoImpl;
import lk.ijse.dto.BranchDto;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Branch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchBoImpl implements BranchBo {

    private BranchDao branchDao = new BranchDaoImpl();

    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public void saveBranch(BranchDto dto) throws SQLException {
        Admin admin = adminDao.getbyId(dto.getAdminId());
        branchDao.save(new Branch(dto.getBranchName(), dto.getContact(), dto.getAddress(), admin));
    }

    @Override
    public BranchDto getBranch(String name) throws SQLException {
        Branch branch = branchDao.get(name);
        return new BranchDto(branch.getBranchId(), branch.getBranchName(), branch.getContact(), branch.getAddress(), branch.getAdmin().getAdminId());
    }

    @Override
    public List<BranchDto> getAllBranches() throws SQLException {
        List<Branch> branches = branchDao.loadAll();
        List<BranchDto> dtos = new ArrayList<>();
        for (Branch branch : branches){
            dtos.add(new BranchDto(branch.getBranchId(), branch.getBranchName(), branch.getContact(), branch.getAddress(), branch.getAdmin().getAdminId()));
        }
        return dtos;
    }

    @Override
    public void updateBranch(BranchDto dto) throws SQLException {
        Admin admin = adminDao.getbyId(dto.getAdminId());
        branchDao.update(new Branch(dto.getBranchId(), dto.getBranchName(), dto.getContact(), dto.getAddress(), admin));

    }

    @Override
    public void deleteBranch(int branchId) throws SQLException {
        branchDao.delete(branchId);

    }

    @Override
    public BranchDto getBranchById(int branchId) throws SQLException {
        return null;
    }
}
