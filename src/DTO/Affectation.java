package DTO;

import java.util.List;

public class Affectation {
    private date startDate;
    private date endDate;
    private Employee employee;
    private Mission mission;

    public date getStartDate() {
        return startDate;
    }

    public void setStartDate(date startDate) {
        this.startDate = startDate;
    }

    public date getEndDate() {
        return endDate;
    }

    public void setEndDate(date endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
