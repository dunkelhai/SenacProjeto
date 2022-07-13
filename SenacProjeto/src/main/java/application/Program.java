package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        //Forma muito ruim de implementar, lógica direto no programa

        if (!checkOut.after(checkIn)){
            System.out.println("Datas inválidas! Check-out precisa ser depois da data de check-in");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Atualize a reserva com as novas datas: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();

            if (checkIn.before(now) || checkOut.before(now)){
                System.out.println("Datas de reserva precisam ser futuras!");
            } if (!checkOut.after(checkIn)){
                System.out.println("Datas inválidas! Check-out precisa ser depois da data de check-in");
            } else {
                reservation = new Reservation(number, checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }

    }
}
