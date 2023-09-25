package Interfaces;

import DTO.Account;
import DTO.Client;
import DTO.Enum.Status;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AccountInterface<T> {
    Optional<T>  add(Optional<T> account) throws SQLException;
    int delete(String accNum);
    Optional<T>  update(Optional<T>  account);
    List<Optional<T> > showByCreationDate(Date creationDate);
    List<Optional<T> > showByStatus(Status status);
    List<Optional<T> > show();
    boolean changeState(String accNum);
    List<T> searchByClient(Client client);
}
