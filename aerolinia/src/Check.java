import java.time.format.DateTimeFormatter;
import java.util.Scanner;

    public class Check
    {

        public static int checkInt()
        {
            String check;
            boolean acabado;
            int check2 = 0;
            Scanner sc = new Scanner(System.in);

            do {
                acabado = true;
                check = sc.next();
                try {
                    check2 = Integer.parseInt(check);

                } catch (Exception e)
                {
                    System.out.println("No valido");
                    acabado = false;
                }
            }while(!acabado);

            return check2;
        }

        public static String hora()
        {
            Scanner sc = new Scanner(System.in);
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
            boolean acabado = false;
            //SimpleDateFormat in;
            String fecha;
            do {
                fecha = sc.nextLine();
                try {
                    dateFormat.parse(fecha);
                    acabado = true;
                } catch (Exception e) {
                    System.out.println("Fecha no valida");
                }
            }while(!acabado);
            return fecha;
        }


    }
