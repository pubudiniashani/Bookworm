package lk.ijse.bo.custom;

import lk.ijse.dto.AdminDto;

import java.sql.SQLException;
import java.util.List;

public interface AdminBo {

    List<AdminDto> getAllAdmins() throws SQLException;

    void saveAdmin(AdminDto adminDto) throws SQLException;




}
