package ui;

import model.Controller;

import java.io.*;
import java.util.Scanner;

public class Main {
    private Controller controller;
    public static Scanner lector = new Scanner(System.in);

    public Main() {
        controller = new Controller();
    };

    public static void main(String[] args) {

        Main objMain = new Main();
        objMain.cargarJson();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Ingresar un país");
            System.out.println("2. Mostrar medalleria");
            System.out.println("3. Mostrar total de medallas");
            System.out.println("4. Mostrar paises");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            int option = lector.nextInt();

            if (option == 1) {
                System.out
                        .print("Ingrese el país, la medalla (oro, plata o bronce) y la cantidad separados por '::': ");
                String[] input = lector.next().split("::");
                String countryName = input[0];
                String medalType = input[1];
                int quantity = Integer.parseInt(input[2]);
                objMain.register(countryName, medalType, quantity);

            } else if (option == 2) {
                objMain.printMedalleria();
            } else if (option == 3) {
                objMain.printTotalMedals();

            } else if (option == 4) {
                objMain.printAlpha();
            } else if (option == 5) {
                break;
            } else {
                System.out.println("Opción inválida, por favor ingrese 1 o 2.");
            }
        }

    }

    public void register(String countryName, String medalType, int quantity) {
        controller.registerCountry(countryName, medalType, quantity);
    }

    public void cargarJson() {
        System.out.println("ingrese la direccion de un archivo txt donde cargaremos y guardaremos los datos.");
        System.out.println(
                "ejemplo:C:\\Users\\shern\\OneDrive\\Documentos\\clases\\Semestre3\\ApoII\\Seguimiento10\\country.txt.");
        String direction = lector.nextLine();
        File file = new File(direction);
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);

                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

                String json = "";
                String line;
                if ((line = reader.readLine()) != null) {
                    json = line;
                }
                fis.close();
                controller.addJson(json, direction);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void printMedalleria() {
        controller.printMedalleria();
    }

    public void printTotalMedals() {
        controller.printTotalMedals();
    }

    public void printAlpha() {
        controller.printAlpha();
    }

}
