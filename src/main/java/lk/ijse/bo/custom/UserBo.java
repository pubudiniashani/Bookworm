package lk.ijse.bo.custom;

import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBo {
    void saveUser(UserDto dto) throws SQLException;

    List<UserDto> getAllUsers();
}
