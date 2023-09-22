package Interfaces;

import DTO.Mission;

public interface MissionInterface {
    Mission add(Mission mission);
    int delete(String code);
}
