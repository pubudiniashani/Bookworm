package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.AdminBo;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AdminDao;
import lk.ijse.dao.custom.impl.AdminDaoImpl;
import lk.ijse.dto.AdminDto;
import lk.ijse.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminBoImpl implements AdminBo {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public List<AdminDto> getAllAdmins() throws SQLException {
        List<Admin> admins = adminDao.loadAll();
        List<AdminDto> adminDtos = new ArrayList<>();

        for (Admin admin:admins) {
            adminDtos.add(new AdminDto(admin.getAdminId(), admin.getName(),admin.getEmail(),admin.getUserName(),
                    admin.getPassword()));
        }
        return adminDtos;
    }

    @Override
    public void saveAdmin(AdminDto adminDto) throws SQLException {
        adminDao.save(new Admin(adminDto.getEmail(), adminDto.getName(),
                 adminDto.getPassword(), adminDto.getUserName()));
    }


}
