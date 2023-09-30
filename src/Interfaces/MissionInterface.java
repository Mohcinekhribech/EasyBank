package Interfaces;

import DTO.Mission;

import java.sql.SQLException;
import java.util.Optional;

public interface MissionInterface {
    Optional<Mission> add(Mission mission) throws SQLException;
    int delete(String code);
}
