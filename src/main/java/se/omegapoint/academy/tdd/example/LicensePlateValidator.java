package se.omegapoint.academy.tdd.example;

/**
 * LicensePlateValidator - [description goes here]
 * Created: 2020-09-11
 * Author: Henrik Stensson, henrik.stensson@omegapoint.se
 */
public class LicensePlateValidator {
    public boolean validate(String licensePlate) {
        return licensePlate.matches("[A-Z]{3}[0-9]{2}[0-9A-Z]");
    }
}
