package se.omegapoint.academy.tdd.example;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class LowerCaseConverter {

    public Collection<String> toLowerCase(Collection<String> strings) {
        return strings.stream().map(String::toLowerCase).toList();
    }
}
