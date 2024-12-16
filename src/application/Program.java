package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = scanner.nextInt();
        System.out.print("Check-In date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(scanner.next());
        System.out.print("Check-Out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(scanner.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in Reservation: Check-Out date must be after check-in date");
        }else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            
            System.out.println();
            System.out.println("Enter date to update the reservation: ");
            System.out.print("Check-In date (dd/MM/yyyy): ");
            checkIn = sdf.parse(scanner.next());
            System.out.print("Check-Out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(scanner.next());
            
            String error = reservation.updateDates(checkIn, checkOut);
            if(error != null){
                System.out.print("Error in reservation: " + error);
            }else {
                System.out.println("Reservation: " + reservation);
            }
            
        }       
        scanner.close();
	}

}
