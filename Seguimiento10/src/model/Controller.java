package model;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

public class Controller {
    private String direction;

    private ArrayList<Country> medalsTable;

    public Controller() {
        this.medalsTable = new ArrayList<>();

    }

    public void registerCountry(String name, String type_medal, int amount) {
        int i = searchArray(name);
        if (i != -1) {
            medalsTable.get(i).addMedal(type_medal, amount);
            writeJson();
        } else {
            Country country = new Country(name);
            country.addMedal(type_medal, amount);
            medalsTable.add(country);
            writeJson();
        }
    }

    private int searchArray(String name) {
        for (int i = 0; i < medalsTable.size(); i++) {
            if (medalsTable.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // C:\\Users\\shern\\OneDrive\\Documentos\\clases\\Semestre3\\ApoII\\Seguimiento10\\country.txt
    public void addJson(String json, String direcion) {
        Gson gson = new Gson();
        Country[] countryFromJson = gson.fromJson(json, Country[].class);
        if (countryFromJson == null) {
            this.direction = direcion;
            return;
        } else {
            for (Country p : countryFromJson) {
                medalsTable.add(p);

            }
            this.direction = direcion;
        }

    }

    public void writeJson() {
        Gson gson = new Gson();
        String json = gson.toJson(medalsTable);

        try {
            FileOutputStream fos = new FileOutputStream(new File(direction));
            fos.write(json.getBytes(StandardCharsets.UTF_8));
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void printMedalleria() {
        Collections.sort(medalsTable);
        for (Country pais : medalsTable) {
            System.out.println(pais.getName() + ": " + pais.getOro() + " oro, " + pais.getPlata() + " plata, "
                    + pais.getBronce() + " bronce");
        }
    }

    public void printTotalMedals() {
        Collections.sort(medalsTable, new CountryComparator());
        for (Country c : medalsTable) {
            System.out.println(c.getName() + " sus medallas son :   " + c.getAllMedals());
        }
    }

    public void printAlpha() {
        for (int i = 1; i < medalsTable.size(); i++) {
            Country countryCurrent = medalsTable.get(i);
            int j = i - 1;
            while (j >= 0 && medalsTable.get(j).getName().compareTo(countryCurrent.getName()) > 0) {
                medalsTable.set(j + 1, medalsTable.get(j));
                j--;
            }
            medalsTable.set(j + 1, countryCurrent);
        }

        for (int i = 0; i < medalsTable.size(); i++) {
            Country pais = medalsTable.get(i);
            System.out.println(pais.getName());
        }
    }

}
