package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBo;
import lk.ijse.dao.custom.UserDao;
import lk.ijse.dao.custom.impl.UserDaoImpl;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserBoImpl implements UserBo {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void saveUser(UserDto dto) throws SQLException {
        userDao.save(new User(dto.getUserName(), dto.getPw(), dto.getEmail()));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }
}
