package Interfaces;

import DTO.Operation;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface OperationInterface {
    Optional<Operation> add(Operation operation) throws SQLException;
    int delete(int operationNumber);
    List<Operation> searchOperation(Operation operation);
    Operation searchOperationByNum(int operationNumber);

}
