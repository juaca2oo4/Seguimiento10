package model;

import java.util.Comparator;

public class CountryComparator implements Comparator<Country> {
    @Override
    public int compare(Country c1, Country c2) {
        return c2.getAllMedals() - c1.getAllMedals();
    }
}
