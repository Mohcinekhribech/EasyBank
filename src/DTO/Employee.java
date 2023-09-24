package DTO;

import java.util.Date;
import java.util.List;

public class Employee extends Person {
    private String registrationNumber ;
    private java.sql.Date  recruitmentDate;
    private List<Operation> operations;
    private List<Affectation> affectations;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public java.sql.Date  getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(java.sql.Date  recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }
}
