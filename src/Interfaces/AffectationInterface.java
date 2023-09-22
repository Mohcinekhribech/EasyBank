package Interfaces;

import DTO.Affectation;

import java.util.List;

public interface AffectationInterface {
    Affectation add(Affectation affectation);
    int delete(Affectation affectation);
    List<Affectation> historicalAffectation();
    void statisticsAffectation();
}