package DAO;

import DTO.Affectation;
import Helpers.Database;
import Interfaces.AffectationInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AffectationDao implements AffectationInterface {
    Connection connection = Database.ConnectToDb();
    @Override
    public Optional<Affectation> add(Affectation affectation) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into affectaion (startDate,endDate,mission_code,employe_registrationNumber) values (?,?,?,?)");
        statement.setDate(1, Date.valueOf(affectation.getStartDate()));
        statement.setDate(2,Date.valueOf(affectation.getEndDate()));
        statement.setString(3,affectation.getMission().getCode());
        statement.setString(4,affectation.getEmployee().getRegistrationNumber());
        if(statement.execute())
        {
            return Optional.of(affectation);
        }
        return Optional.empty();
    }

    @Override
    public int delete(Affectation affectation) {
        return 0;
    }

    @Override
    public List<Affectation> historicalAffectation() {
        return null;
    }

    @Override
    public void statisticsAffectation() {

    }
}
