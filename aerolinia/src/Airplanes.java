import java.util.*;
public class Airplanes {
    private String name;
    private String creationDate;
    private double fuelCapacity;
    private final int totalSeats;
    private final int ID;

    public Airplanes(String name, String creationDate, double fuelCapacity, int totalSeats, int ID) {
        this.name = name;
        this.creationDate = creationDate;
        this.fuelCapacity = fuelCapacity;
        this.totalSeats = totalSeats;
        this.ID = ID;
    }

    public static ArrayList<Airplanes> airplanes() {
        ArrayList<Airplanes> airplanes = new ArrayList<>();
        airplanes.add(new Airplanes("Airbus A320", "01/01/2005", 5000.0, 150,1));
        airplanes.add(new Airplanes("Boeing 737", "15/02/2002", 4500.0, 130,2));
        airplanes.add(new Airplanes("Airbus A330", "03/04/2007", 10000.0, 250,3));
        airplanes.add(new Airplanes("Boeing 747", "12/05/1998", 15000.0, 300,4));
        airplanes.add(new Airplanes("Embraer E190", "07/09/2012", 3000.0, 100,5));
        airplanes.add(new Airplanes("Bombardier CRJ700", "11/11/2008", 4000.0, 70,6));
        airplanes.add(new Airplanes("Airbus A380", "22/08/2010", 20000.0, 500,7));
        airplanes.add(new Airplanes("Boeing 787", "09/06/2015", 12000.0, 200,8));
        airplanes.add(new Airplanes("Embraer Phenom 100", "18/03/2013", 2000.0, 5,9));
        airplanes.add(new Airplanes("Cessna Citation X", "25/01/2011", 3000.0, 8,10));

        return airplanes;
    }


    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public int getID() { return ID; }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public static void viewAirplanes(ArrayList<Airplanes> airplanes)
    {
            for (int i = 0; i < airplanes.size(); i++) {
                System.out.println(airplanes.get(i).toString() + " ");
            }
    }



    public String toString() {
        return "Nom Avió: " + name + " -- Data Creació: " + creationDate + " -- Capacitat Tanc Gasolina: " + fuelCapacity + " --  Capacitat Passatgers: " + totalSeats + " -- ID: " + ID;
    }
}
