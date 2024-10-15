package model.animal.comparators;

import model.animal.Animal;

import java.util.Comparator;

public class BirthDayComparator<T extends Animal> implements Comparator<T> {
    @Override
    public int compare(T a1, T a2) {
        return a1.getDateOfBirth().compareTo(a2.getDateOfBirth());
    }
}
