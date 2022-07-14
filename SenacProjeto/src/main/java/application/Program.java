package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    //Execao vai ser tratada e nao propagada
    public static void main(String[] args) {

        System.out.println("Digite o numero do quarto: ");
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Atualize a reserva com as novas datas: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation " + reservation);

        } catch (ParseException e) {
            System.out.println("Data invalida" + e.getMessage());

        } catch (DomainException e){
            System.out.println("Erro na reserva " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Erro inesperado" + e.getMessage());
        }

        sc.close();

    }
    }

