import java.util.ArrayList;

public class Pilots {

    private String pilotName;
    private String pilotSurname;
    private String pilotDni;
    private String pilotBirthday;
    private int pilotPhoneNumber;
    private int pilotID;

    public Pilots(String pilotName, String pilotSurname, String pilotDni, String pilotBirthday, int pilotPhoneNumber, int pilotID) {
        this.pilotName = pilotName;
        this.pilotSurname = pilotSurname;
        this.pilotDni = pilotDni;
        this.pilotBirthday = pilotBirthday;
        this.pilotPhoneNumber = pilotPhoneNumber;
        this.pilotID = pilotID;
    }

    public static ArrayList<Pilots> pilots() {
        ArrayList<Pilots> pilots = new ArrayList<>();
        pilots.add(new Pilots("Lucas", "Perez", "45745745L", "14/05/1967", 543345435, 1));
        pilots.add(new Pilots("Maria", "Gonzalez", "23456789A", "08/09/1985", 674849237, 2));
        pilots.add(new Pilots("Juan", "Lopez", "09876543B", "23/12/1978", 674849238, 3));
        pilots.add(new Pilots("Luisa", "Martinez", "34567890C", "01/02/1990", 674849239, 4));
        pilots.add(new Pilots("Carlos", "Ruiz", "45678901D", "17/07/1982", 674849240, 5));
        pilots.add(new Pilots("Sofia", "Sanchez", "56789012E", "03/04/1994", 674849241, 6));
        pilots.add(new Pilots("Pablo", "Garcia", "67890123F", "22/11/1975", 674849242, 7));
        pilots.add(new Pilots("Carmen", "Alvarez", "78901234G", "19/06/1988", 674849243, 8));
        pilots.add(new Pilots("Pedro", "Diaz", "89012345H", "11/09/1979", 674849244, 9));
        pilots.add(new Pilots("Ana", "Ramirez", "90123456J", "30/01/1992", 674849245, 10));

        return pilots;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public String getPilotSurname() {
        return pilotSurname;
    }

    public void setPilotSurname(String pilotSurname) {
        this.pilotSurname = pilotSurname;
    }

    public String getPilotDni() {
        return pilotDni;
    }

    public void setPilotDni(String pilotDni) {
        this.pilotDni = pilotDni;
    }

    public String getPilotBirthday() {
        return pilotBirthday;
    }

    public void setPilotBirthday(String pilotBirthday) {
        this.pilotBirthday = pilotBirthday;
    }

    public int getPilotPhoneNumber() {
        return pilotPhoneNumber;
    }

    public void setPilotPhoneNumber(int pilotPhoneNumber) {
        this.pilotPhoneNumber = pilotPhoneNumber;
    }

    public int getPilotID() {
        return pilotID;
    }

    public void setPilotID(int pilotID) {
        this.pilotID = pilotID;
    }

    public static void viewPilots(ArrayList<Pilots> pilots) {
        for(Pilots pilot : pilots) {
            System.out.println("ID: " + pilot.getPilotID());
            System.out.println("Nom: " + pilot.getPilotName());
            System.out.println("Cognom: " + pilot.getPilotSurname());
            System.out.println("DNI: " + pilot.getPilotDni());
            System.out.println("Data Naixement: " + pilot.getPilotBirthday());
            System.out.println("Numero de Telèfon: " + pilot.getPilotPhoneNumber());
            System.out.println(" ");
        }
    }

    public static void viewPilotInfoFlight(ArrayList<Pilots> pilots) {
        for(Pilots pilot : pilots) {
            System.out.println("Nom: " + pilot.getPilotName());
            System.out.println("Cognom: " + pilot.getPilotSurname());
            System.out.println(" ");
        }
    }

    public String toString() {
        return "[ID: " + pilotID + ", Name: " + pilotName + ", Surname: " + pilotSurname + ", DNI: " + pilotDni + ", Birthday: " + pilotBirthday + ", Phone number: " + pilotPhoneNumber + "]";
    }

}
