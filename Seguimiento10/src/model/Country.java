package model;

public class Country implements Comparable<Country> {

    private String name;
    private int oro;
    private int plata;
    private int bronce;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    public int getBronce() {
        return bronce;
    }

    public void setBronce(int bronce) {
        this.bronce = bronce;
    }

    public void addMedal(String type_medal, int amount) {
        switch (type_medal) {
            case "oro":
                oro += amount;
                break;
            case "plata":
                plata += amount;
                break;
            case "bronce":
                bronce += amount;
                break;
            default:
                break;
        }

    }

    @Override
    public int compareTo(Country country) {
        int result = Integer.compare(country.getOro(), this.oro);
        if (result != 0) {
            return result;
        }

        result = Integer.compare(country.getPlata(), this.plata);
        if (result != 0) {
            return result;
        }

        result = Integer.compare(country.getBronce(), this.bronce);
        if (result != 0) {
            return result;
        }
        return this.name.compareTo(country.getName());
    }

    public int getAllMedals() {
        return oro + plata + bronce;
    }

}
