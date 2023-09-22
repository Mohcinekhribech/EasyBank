package Interfaces;

import DTO.Operation;

import java.util.List;

public interface OperationInterface {
    Operation add(Operation operation);
    int delete(int operationNumber);
    List<Operation> searchOperation(Operation operation);
    Operation searchOperationByNum(int operationNumber);

}
