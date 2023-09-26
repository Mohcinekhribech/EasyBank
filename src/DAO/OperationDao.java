package DAO;

import DTO.Operation;
import Helpers.Database;
import Interfaces.OperationInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class OperationDao implements OperationInterface {
    Connection connection = Database.ConnectToDb();
        @Override
        public Optional<Operation> add(Operation operation) throws SQLException {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO operation (date, type, price, accountNumber , registrationNumber) VALUES (?, ?::operationType, ?, ?, ?)");
            statement.setDate(1, Date.valueOf(operation.getDate()));
            statement.setString(2, String.valueOf(operation.getType()));
            statement.setDouble(3, operation.getPrice());
            statement.setString(4, operation.getAccount().getAccountNumber());
            statement.setString(5,operation.getEmployee().getRegistrationNumber());
            if(statement.executeUpdate()>0)
            {
                connection.commit();
                return Optional.of(operation);
            }
            connection.rollback();
            return Optional.empty();
        }

    @Override
    public int delete(int operationNumber) {
        return 0;
    }

    @Override
    public List<Operation> searchOperation(Operation operation) {
        return null;
    }

    @Override
    public Operation searchOperationByNum(int operationNumber) {
        return null;
    }
}
