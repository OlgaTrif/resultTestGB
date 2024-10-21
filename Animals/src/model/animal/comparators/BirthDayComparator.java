package model.animal.comparators;

import model.animal.Animal;

import java.util.Comparator;

public class BirthDayComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
