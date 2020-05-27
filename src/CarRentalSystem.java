import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CarRentalSystem {

    private static Scanner sc = new Scanner(System.in);
    private HashMap<String, String> rentedCars =
            new HashMap<String, String>(100, 0.5f);
    private HashMap<String, RentedCars> ceva=new HashMap<String, RentedCars>(100,0.5f);
    private static String getPlateNo() {
        System.out.println("Introduceti numarul de inmatriculare:");
        return sc.nextLine();
    }

    private static String getOwnerName() {
        System.out.println("Introduceti numele proprietarului:");
        return sc.nextLine();
    }
    //2
    private int getCarsNo(String ownerName){
        return this.ceva.get(ownerName).getSize();
    }
    // search for a key in hashtable
    private boolean isCarRent(String plateNo) {
        return rentedCars.containsKey(plateNo);
    }
    private ArrayList<String> getCarsList(String ownerName){
        return this.ceva.get(ownerName).getPlates();
    }
    // get the value associated to a key
    private String getCarRent(String plateNo) {
        if(this.isCarRent(plateNo)==false)
            return "Autov nu este in sistem";
        return rentedCars.get(plateNo);
    }

    // add a new (key, value) pair
    private void rentCar(String plateNo, String ownerName) {
        if(this.isCarRent(plateNo)==false)
            rentedCars.put(plateNo, ownerName);
        else System.out.println("Masina exista deja in sistem.");
    }

    // remove an existing (key, value) pair
    private void returnCar(String plateNo) {
        String rez=rentedCars.remove(plateNo);
        if(rez.equals(null))
            System.out.println("Stergerea nu s-a putut realiza");
        else System.out.println("Stergerea a fost realizata cu succes");
    }


    private static void printCommandsList() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua pereche (masina, sofer)");
        System.out.println("check        - Verifica daca o masina este deja luata");
        System.out.println("remove       - Sterge o masina existenta din hashtable");
        System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
        System.out.println("quit         - Inchide aplicatia");
    }

    public void run() {
        boolean quit = false;
        while(!quit) {
            System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            String command = sc.nextLine();
            switch(command) {
                case "help":
                    printCommandsList();
                    break;
                case "add":
                    rentCar(getPlateNo(), getOwnerName());
                    break;
                case "check":
                    System.out.println(isCarRent(getPlateNo()));
                    break;
                case "remove":
                    returnCar(getPlateNo());
                    break;
                case "getOwner":
                    System.out.println(getCarRent(getPlateNo()));
                    break;
                case "quit":
                    System.out.println("Aplicatia se inchide...");
                    quit = true;
                    break;
                default:
                    System.out.println("Unknown command. Choose from:");
                    printCommandsList();
            }
        }
    }

    public static void main(String[] args) {

        // create and run an instance (for test purpose)
        new CarRentalSystem().run();

    }
}