package lk.ijse.bo.custom;

import lk.ijse.dto.BranchDto;

import java.sql.SQLException;
import java.util.List;

public interface BranchBo {
    void saveBranch(BranchDto dto) throws SQLException;

    BranchDto getBranch(String name) throws  SQLException;

    List<BranchDto> getAllBranches() throws SQLException;

    void updateBranch(BranchDto branchDto) throws SQLException;

    void deleteBranch(int branchId) throws SQLException;

    BranchDto getBranchById(int branchId) throws SQLException;

}
