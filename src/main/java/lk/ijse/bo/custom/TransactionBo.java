package lk.ijse.bo.custom;

import lk.ijse.dto.TransactionDto;

import java.sql.SQLException;

public interface TransactionBo {

    void save(TransactionDto dto) throws SQLException;
}
