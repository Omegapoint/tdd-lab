package se.omegapoint.academy.tdd.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LicensePlateValidator {
    PrivatePlateDatabase privatePlateDatabase;
    public LicensePlateValidator(PrivatePlateDatabase privatePlateDatabase){
        this.privatePlateDatabase = privatePlateDatabase;
    }

    public LicensePlateValidator() {
    }


    public boolean validate1(String licensePlate) {
        return true;
    }

    public boolean validate2(String licensePlate) {
        for (int i = 0; i < 6; i++) {
            char character = licensePlate.charAt(i);
            if (i < 3 && !Character.isLetter(character)) {
                return false;
            } else if (i >= 3 && !Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }

    public boolean validate3(String licensePlate) {
        for (int i = 0; i < 6; i++) {
            char character = licensePlate.charAt(i);
            if (i < 3 && !Character.isLetter(character)) {
                return false;
            } else if (i >= 3 && i <=4 && !Character.isDigit(character)) {
                return false;
            } else if (i == 5 && !Character.isLetterOrDigit(character)) {
                return false;
            }
        }
        return true;
    }

    public boolean validate4(String licensePlate) {
        if (licensePlate.length() != 6) return false;
        for (int i = 0; i < 6; i++) {
            char character = licensePlate.charAt(i);
            if (i < 3 && !Character.isLetter(character)) {
                return false;
            } else if (i >= 3 && i <=4 && !Character.isDigit(character)) {
                return false;
            } else if (i == 5 && !Character.isLetterOrDigit(character)) {
                return false;
            }
        }
        return true;
    }

    public boolean validate5(String licensePlate) {
        // ABCDEFGH _I_ JKLMNOP _Q_ RSTU _V_ WXYZ
        // A  -   H     J  -  P     R- U     W- Z
        // A-H          J-P         R-U      W-Z
        // A-HJ-PR-UW-Z
        // Notera skillnaden i sista reguljära uttrycket (med O)
        return licensePlate.matches("[A-HJ-PR-UW-Z]{3}[0-9]{2}[A-HJ-NPR-UW-Z1-9]");
    }

    public boolean validate(String licensePlate) {
        if (licensePlate.length() != 6) return false;

        try {
            List<String> illegalWords = Files.readAllLines(Path.of("src/main/resources/illegalWords.txt"));
            if (illegalWords.contains(licensePlate.substring(0, 3))) {
                return false;
            }
        } catch (Exception e) {
            // handle
        }

        return licensePlate.matches("[A-HJ-PR-UW-Z]{3}[0-9]{2}[A-HJ-NPR-UW-Z1-9]");
    }

    public boolean validateWithCustom(String licensePlate) {
        if (licensePlate.length() == 6) {
            try {
                List<String> illegalWords = Files.readAllLines(Path.of("src/main/resources/illegalWords.txt"));
                if (illegalWords.contains(licensePlate.substring(0, 3))) {
                    return false;
                }
            } catch (Exception e) {
                // handle
            }
        }
        if (licensePlate.length() >= 2 && licensePlate.length() <= 7) {
            return licensePlate.matches("[A-HJ-PR-UW-Z]{3}[0-9]{2}[A-HJ-NPR-UW-Z1-9]") || privatePlateDatabase.lookup(licensePlate);
        }

        return false;
    }
}
