package DAO;

import DTO.Mission;
import Helpers.Database;
import Interfaces.MissionInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class MissionDao implements MissionInterface {
    Connection connection = Database.ConnectToDb();
    @Override
    public Optional<Mission> add(Mission mission) throws SQLException {
        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO mission (code, name, description) VALUES (?, ?, ?)");
        statement.setString(1, mission.getCode());
        statement.setString(2,mission.getName());
        statement.setString(3,mission.getDescription());
        if(statement.executeUpdate()>0)
        {
            connection.commit();
            return Optional.of(mission);
        }
        connection.rollback();
        return Optional.empty();

    }

    @Override
    public int delete(String code) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("delete from mission where code = ?");
            statement.setString(1,code);
            return statement.executeUpdate();
        }catch(Exception e)
        {
            throw new RuntimeException();
        }
    }
}
