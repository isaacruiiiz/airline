import java.time.format.DateTimeFormatter;
import java.util.*;

public class Flight {
    static ArrayList<Pilots> pilotsList;
    static ArrayList<Airplanes> airplanesList;
    private int seats;
    private String originCountry;
    private String destinationCountry;
    private static int flightNumber = 0;
    private String arriveTime;
    private String departureTime;
    private int flightDuration;
    private Pilots pilot;
    private Airplanes airplane;

    ArrayList<Flight> flightList = new ArrayList<Flight>();

    ArrayList<Flight> reservationList = new ArrayList<>();

    public Flight(String originCountry, String destinationCountry, int flightNumber, String arriveTime, String departureTime, int flightDuration, Pilots pilot, Airplanes airplane) {
        this.originCountry = originCountry;
        this.destinationCountry = destinationCountry;
        this.flightNumber = flightNumber;
        this.arriveTime = arriveTime;
        this.departureTime = departureTime;
        this.flightDuration = flightDuration;
        this.pilot = pilot;
        this.airplane = airplane;
    }

    public Flight(int seats, int flightNumber, String destinationCountry, int flightDuration, String departureTime, String arriveTime, Pilots pilot, Airplanes airplane) {
        this.seats = seats;
        this.flightNumber = flightNumber;
        this.destinationCountry = destinationCountry;
        this.flightDuration = flightDuration;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.pilot = pilot;
        this.airplane = airplane;
    }

    public void ModifiedFlight(int flightNumber, String destinationCountry, int flightDuration, String departureTime, String arriveTime, Pilots pilot, Airplanes airplane) {
        this.flightNumber = flightNumber;
        this.destinationCountry = destinationCountry;
        this.flightDuration = flightDuration;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.pilot = pilot;
        this.airplane = airplane;
    }

    public static void createFlight(ArrayList<Flight> flightList) {
        String originCountry;
        String destinationCountry;
        Date arriveTime;
        String departureTime;
        int flightDuration;
        int pilotCode;
        int airplaneCode;

        pilotsList = Pilots.pilots();
        airplanesList = Airplanes.airplanes();

        System.out.println("Introdueix un codi per al vol: ");
        flightNumber = Teclat.llegirInt();

        System.out.println("Introdueix el ID del avió que vols per al vol");
        Airplanes.viewAirplanes(airplanesList);
        airplaneCode = (Teclat.llegirInt()-1);

        System.out.println("Introdueix el ID del pilot que vols per al vol");
        Pilots.viewPilots(pilotsList);
        pilotCode = (Teclat.llegirInt()-1);

        System.out.println("Introdueix el pais de sortida:");
        originCountry = Teclat.llegirString();

        System.out.println("Introdueix el pais de destí:");
        destinationCountry = Teclat.llegirString();

        System.out.println("Duració del vol (min)");
        flightDuration = Check.checkInt();

        System.out.println("Data i hora de sortida? (dd/mm/yyyy hh:mm:ss)");
        departureTime = Check.hora();
        Date departureTime2 = new Date(departureTime);
        arriveTime = new Date(departureTime2.getTime()+flightDuration*60000);

        flightList.add(new Flight(originCountry,destinationCountry,flightNumber,arriveTime.toString(),departureTime,flightDuration,pilotsList.get(pilotCode),airplanesList.get(airplaneCode)));

    }

    public static void visualizeFlight(ArrayList<Flight> flightList){
        if (flightList.size() >= 1) {
            System.out.println("Numero de vols creats: " + flightList.size());

            for (int i = 0; i < flightList.size() ; i++)
            {
                System.out.println(flightList.get(i));
            }
        }
        else {
            System.out.println("No hi han vols creats");
        }
    }

    public static void ModifyFlight(ArrayList<Flight> flightList) {
        pilotsList = Pilots.pilots();
        airplanesList = Airplanes.airplanes();

        int modifyFlightNumber = 0;
        int flightNumber = 0;

        String destinationCountry;
        int flightDuration;
        String departureTime;
        Date arriveTime;
        int pilotCode;
        int airplaneCode;

        int modifyOptionQuestion = 0; //asks the user if he wants to modify a complete flight or just a part of it
        int modifySingleElementOption = 0; //asks the user what element of the flight wants to modify

        ArrayList<Pilots> pilots;
        ArrayList<Airplanes> airplanes;

        pilots = Pilots.pilots();
        airplanes = Airplanes.airplanes();

        
        for (int i = 0; i < flightList.size() ; i++)
        {
            System.out.println(flightList.get(i).toString());
        }

        System.out.println("Escolleix el vol que vols modificar?");
        System.out.println();
        modifyFlightNumber = Check.checkInt();
        flightNumber = modifyFlightNumber;
        modifyFlightNumber = modifyFlightNumber - 1;
        System.out.println();
        System.out.println("Vols modificar tot el vol?");
        System.out.println();
        System.out.println("1-Si" + '\n' + "2-No");
        modifyOptionQuestion = Check.checkInt();
        if(modifyOptionQuestion == 1)
        {
            System.out.println("Introdueix el nou destí");
            destinationCountry = Teclat.llegirString();

            System.out.println("Cuant dura (minuts)");
            flightDuration = Check.checkInt();

            System.out.println("Data i hora del vol (dd/mm/aaaa hh:mm:ss)?");
            departureTime = Check.hora();
            Date departureTime2 = new Date(departureTime);
            arriveTime = new Date(departureTime2.getTime() + flightDuration * 60000);

            System.out.println("Selecciona l'avió: ");
            Airplanes.viewAirplanes(airplanesList);
            airplaneCode = (Teclat.llegirInt()-1);

            System.out.println("Selecciona el pilot: ");
            Pilots.viewPilots(pilotsList);
            pilotCode = (Teclat.llegirInt()-1);
            flightList.get(modifyFlightNumber).ModifiedFlight(flightNumber, destinationCountry, flightDuration, departureTime, arriveTime.toString(), pilots.get(pilotCode), airplanes.get(airplaneCode));
        }
        if(modifyOptionQuestion == 2)
        {
            System.out.println("Quin element del vol vols modificar?");
            System.out.println("1. Destí");
            System.out.println("2. Duració del vol");
            System.out.println("3. Data i hora de sortida");
            System.out.println("4. Avió");
            System.out.println("5. Pilot");

            modifySingleElementOption = Teclat.llegirInt();

            switch (modifySingleElementOption) {
                case 1:
                    System.out.println("Escriu el nou destí: ");
                    destinationCountry = Teclat.llegirString();
                    flightList.get(modifyFlightNumber).setDestinationCountry(destinationCountry);
                    break;
                case 2:
                    flightDuration = Check.checkInt();
                    departureTime = flightList.get(modifyFlightNumber).getDepartureTime();
                    Date departureTime2 = new Date(departureTime);
                    arriveTime = new Date(departureTime2.getTime() + flightDuration * 60000);
                    flightList.get(modifyFlightNumber).setFlightDuration(flightDuration);
                    flightList.get(flightNumber).setArriveTime(arriveTime.toString());
                    break;
                case 3:
                    departureTime = Check.hora();
                    departureTime2 = new Date(departureTime);
                    flightDuration = flightList.get(modifyFlightNumber).getFlightDuration();
                    arriveTime = new Date(departureTime2.getTime() + flightDuration * 60000);
                    flightList.get(modifyFlightNumber).setDepartureTime(departureTime);
                    flightList.get(modifyFlightNumber).setArriveTime(arriveTime.toString());
                    break;
                case 4:
                    airplaneCode = Check.checkInt() - 1;
                    flightList.get(modifyFlightNumber).setAirplane(airplanes.get(airplaneCode));
                    break;
                case 5:
                    pilotCode = Check.checkInt() - 1;
                    flightList.get(modifyFlightNumber).setPilot(pilots.get(pilotCode));
                    break;
            }


        }

    }

    public static void DeleteFlight(ArrayList<Flight> flightList) {
        int flightCode;
        for (int i = 0; i < flightList.size() ; i++)
        {
            System.out.println(flightList.get(i).toString());
        }
        System.out.println("Que vol vols esborrar?");
        flightCode = Teclat.llegirInt();
        flightCode = flightCode-1;
        flightList.remove(flightCode);
    }

    public static void buyTickets(ArrayList<Flight> flightList, ArrayList<Flight> reservationList) {
        int flightCode = 0;
        int airplane = 0;
        int seats = 0;
        int ticketPrice = 60;
        int continueBuying = 0;
        boolean finish = false;
        boolean flightsAvailable = true;


        System.out.println("Vols disponibles: ");
        System.out.println(" ");
        if(flightList.size() == 0)
        {
            System.out.println("No hi han vols disponibles");
            System.out.println(" ");
            System.out.println("0. Sortir");
            flightsAvailable = false;
            continueBuying = Check.checkInt();
        }
        if(flightsAvailable)
        {
            for (int i = 0; i < flightList.size(); i++) {
                System.out.println(flightList.get(i).toString());
            }

            System.out.println(" ");
            do {
                System.out.println("Selecciona un vol: ");
                flightCode = Check.checkInt();
                flightCode = flightCode - 1;
            }
            while (flightCode > flightList.size());
            airplane = flightList.get(flightCode).airplane.getTotalSeats();
                System.out.println("Cuants seients vols reservar?");
                seats = Check.checkInt();
                if (seats <= airplane) {
                    airplane = airplane - seats;
                    flightList.get(flightCode).airplane.getTotalSeats();
                    ticketPrice = ticketPrice * seats;
                    System.out.println("Preu total: " + ticketPrice);
                }
                else {
                    System.out.println("No hi han mes seients disponibles");
                }
        }
    }

    public static void viewInformation(ArrayList<Flight> reservationList) {
        for (int i = 0; i < reservationList.size() ; i++)
        {
            System.out.println(reservationList.get(i).toStringViewFlight());
        }
    }

    public static void cancelPurchasedTickets(ArrayList<Flight> flightList, ArrayList<Flight> reservationList) {
        System.out.println("Introdueix el número de vol per cancel·lar les entrades reservades:");
        int flightNumberToCancel = Teclat.llegirInt();

        for (int i = reservationList.size() - 1; i >= 0; i--) {
            Flight flight = reservationList.get(i);
            if (flight.getFlightNumber() == flightNumberToCancel) {
                reservationList.remove(i);
            }
        }

        System.out.println("Entrades reservades cancel·lades per al vol número " + flightNumberToCancel);
    }




    public void setPiloto(Pilots pilot) {
        this.pilot = pilot;
    }

    public void setAirplane(Airplanes airplane) {
        this.airplane = airplane;
    }


    public Pilots getPilot() {
        return pilot;
    }

    public void setPilot(Pilots pilot) {
        this.pilot = pilot;
    }

    public Airplanes getAirplane() {
        return airplane;
    }

    public static ArrayList<Flight> getFlightList(ArrayList<Flight> flightList) {
        return flightList;
    }

    public void setFlightList(ArrayList<Flight> flightList) {
        this.flightList = flightList;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Pilots getPilots() {
        return pilot;
    }

    public void setPilots(Pilots pilots) {
        this.pilot = pilots;
    }

    public Airplanes getAirplanes() {
        return airplane;
    }

    public void setAirplanes(Airplanes airplanes) {
        this.airplane = airplanes;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String toString() {
        return "Flight{" +
                "originCountry='" + originCountry + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                ", flightNumber=" + flightNumber +
                ", arriveTime='" + arriveTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", flightDuration=" + flightDuration +
                ", pilot=" + pilot +
                ", airplane=" + airplane +
                '}';
    }

    public String toStringViewFlight() {
        return "Flight{" +
                "seats=" + seats +
                ", originCountry='" + originCountry + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                ", arriveTime='" + arriveTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", flightDuration=" + flightDuration +
                ", pilot=" + pilot +
                ", airplane=" + airplane +
                ", flightList=" + flightList +
                ", reservationList=" + reservationList +
                '}';
    }
}
