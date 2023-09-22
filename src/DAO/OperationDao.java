package DAO;

import DTO.Operation;
import Interfaces.OperationInterface;

import java.util.List;

public class OperationDao implements OperationInterface {
    @Override
    public Operation add(Operation operation) {
        return null;
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
