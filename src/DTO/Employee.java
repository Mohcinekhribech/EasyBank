package DTO;

import java.util.List;

public class Employee extends Person {
    private String registrationNumber ;
    private Date recruitmentDate;
    private List<Operation> operations;
    private List<Affectation> affectations;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(Date recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }
}
