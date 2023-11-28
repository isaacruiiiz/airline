import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Airplanes> airplanesList;
    static ArrayList<Pilots> pilotsList;
    static ArrayList<Flight> flightList = new ArrayList<>();
    static ArrayList<Flight> reservationList = new ArrayList<>();

    public static void main(String[] args) {
        airplanesList = Airplanes.airplanes();
        pilotsList = Pilots.pilots();

        // Preguntar al usuario cómo desea iniciar sesión
        int signInElection = roleElection();

        // Cuando el usuario selecciona cómo quiere iniciar sesión, el programa abre el menú correspondiente para el cliente o el inicio de sesión para el administrador
        displayPertinentMenu(signInElection);
    }

    private static int roleElection() {
        int signInElection;
        do {
            System.out.println("Com vols iniciar sessió?");
            System.out.println("1. Client");
            System.out.println("2. Administrador");
            System.out.println("0. Sortir");
            signInElection = Teclat.llegirInt();
            System.out.println();
        } while (signInElection != 1 && signInElection != 2 && signInElection != 0);
        return signInElection;
    }

    private static void displayPertinentMenu(int signInElection) {
        switch (signInElection) {
            case 1:
                customerMenu();
                break;
            case 2:
                signInAdmin(Users.users());
                break;
            case 0:
                break;
        }
    }

    private static void signInAdmin(ArrayList<Users> users) {
        int attempts = 0;
        boolean isAdmin = false;

        do {
            System.out.println("Introdueix el nom d'usuari:");
            String username = Teclat.llegirString();

            System.out.println("Introdueix la contrasenya:");
            String password = Teclat.llegirString();

            for (Users user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    isAdmin = user.isAdmin();
                    break;
                }
            }

            if (isAdmin) {
                System.out.println("Benvolgut, administrador!");
                adminMenu();
            } else {
                attempts++;
                System.out.println("L'usuari o la contrasenya són incorrectes o no pertanyen a un administrador.");
                System.out.println("Torna a intentar-ho.");
            }
        } while (attempts < 3);

        if (!isAdmin) {
            System.out.println("Has superat el límit de intents. Torna a seleccionar una opció d'inici de sessió.");
            int signInElection = roleElection();
            displayPertinentMenu(signInElection);
        }
    }

    // Menú de administrador
    private static void adminMenu() {
        int adminMenuElection;
        do {
            System.out.println("""
                    Elegeix una opció:
                    1- Crear vol
                    2- Visualitzar dades vol
                    3- Modificar dades vol
                    4- Esborrar vol
                    5- Mostra els avions
                    6- Mostrar els pilots
                    0- Sortir""");
            adminMenuElection = Teclat.llegirInt();
            adminElection(adminMenuElection);
        } while (adminMenuElection != 0);
    }

    private static void adminElection(int adminMenuElection) {
        switch (adminMenuElection) {
            case 1:
                adminCreateFlight();
                break;
            case 2:
                adminVisualizeFlight();
                break;
            case 3:
                adminModifyFlight();
                break;
            case 4:
                adminDeleteFlight();
                break;
            case 5:
                adminShowAirplanes();
                break;
            case 6:
                adminShowPilots();
                break;
            case 0:
                int signInElection = roleElection();
                displayPertinentMenu(signInElection);
                break;
            default:
                System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
        }
    }

    private static void adminShowPilots() {
        int exitShowPilots;
        do {
            Pilots.viewPilots(pilotsList);
            System.out.println("Vols sortir?");
            System.out.println("0. Sortir");
            exitShowPilots = Teclat.llegirInt();
        } while (exitShowPilots != 0);
        adminMenu();
    }

    private static void adminShowAirplanes() {
        int exitShowAirplanes;
        do {
            Airplanes.viewAirplanes(airplanesList);
            System.out.println("Vols sortir?");
            System.out.println("0. Sortir");
            exitShowAirplanes = Teclat.llegirInt();
        } while (exitShowAirplanes != 0);
        adminMenu();
    }

    private static void adminDeleteFlight() {
        flightList = Flight.getFlightList(flightList);
        int exitDeleteFlight;
        do {
            Flight.DeleteFlight(flightList);
            System.out.println("Esborrar un altre vol o sortir?");
            System.out.println("0. Sortir");
            System.out.println("1. Esborrar un altre vol");
            exitDeleteFlight = Teclat.llegirInt();
        } while (exitDeleteFlight != 0);
        adminMenu();
    }

    private static void adminModifyFlight() {
        flightList = Flight.getFlightList(flightList);
        int exitModifyFlight;
        do {
            Flight.ModifyFlight(flightList);
            System.out.println("Modificar un altre vol o sortir?");
            System.out.println("0. Sortir");
            System.out.println("1. Modificar un altre vol");
            exitModifyFlight = Teclat.llegirInt();
        } while (exitModifyFlight != 0);
        adminMenu();
    }

    private static void adminVisualizeFlight() {
        int exitVisualizeFlight;
        do {
            flightList = Flight.getFlightList(flightList);
            Flight.visualizeFlight(flightList);

            System.out.println();
            System.out.println("Vols sortir?");
            System.out.println("0. Sortir");
            exitVisualizeFlight = Teclat.llegirInt();
        } while (exitVisualizeFlight != 0);
        adminMenu();
    }

    private static void adminCreateFlight() {
        flightList = Flight.getFlightList(flightList);
        int exitCreateFlight;
        do {
            Flight.createFlight(flightList);
            System.out.println("Crear un altre vol o sortir?");
            System.out.println("0. Sortir");
            System.out.println("1. Crear un altre vol");
            exitCreateFlight = Teclat.llegirInt();
        } while (exitCreateFlight != 0);
        adminMenu();
    }

    // Menú del cliente
    private static void customerMenu() {
        int customerMenuElection;
        do {
            System.out.println("""
                    Elegeix una opció:
                    1- Visualitzar informació del vol
                    2- Comprar bitllets
                    3- Anul·lar bitllets
                    0- Sortir al menú principal""");
            customerMenuElection = Teclat.llegirInt();
            customerElection(customerMenuElection);
        } while (customerMenuElection != 0);
    }

    public static void customerElection(int customerMenuElection) {
        switch (customerMenuElection) {
            case 1:
                customerMenuFlightInfo();
                break;
            case 2:
                customerMenuBuyTickets();
                break;
            case 3:
                customerMenuCancelTickets();
                break;
            case 0:
                int signInElection = roleElection();
                displayPertinentMenu(signInElection);
                break;
            default:
                System.out.println("Opció invàlida. Si us plau, selecciona una opció vàlida.");
        }
    }

    private static void customerMenuCancelTickets() {
        Flight.cancelPurchasedTickets(flightList, reservationList);
    }

    private static void customerMenuBuyTickets() {
        boolean exit = false;
        while (!exit) {
            Flight.buyTickets(flightList, reservationList);
            System.out.println("Vols seguir comprant?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int exitBuyTickets = Teclat.llegirInt();
            if (exitBuyTickets == 2) {
                exit = true;
            }
        }
        customerMenu();
    }

    private static void customerMenuFlightInfo() {
        int exitVisualizeFlight;
        do {
            flightList = Flight.getFlightList(flightList);
            Flight.visualizeFlight(flightList);

            System.out.println();
            System.out.println("Vols sortir?");
            System.out.println("0. Sortir");
            exitVisualizeFlight = Teclat.llegirInt();
        } while (exitVisualizeFlight != 0);
        customerMenu();
    }

    public static void clearConsole() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_1);
            robot.delay(10);
        } catch (AWTException ignored) {
        }
    }
}





