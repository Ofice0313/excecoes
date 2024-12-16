package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
	        System.out.print("Room number: ");
	        int number = scanner.nextInt();
	        System.out.print("Check-In date (dd/MM/yyyy): ");
	        Date checkIn = sdf.parse(scanner.next());
	        System.out.print("Check-Out date (dd/MM/yyyy): ");
	        Date checkOut = sdf.parse(scanner.next());
	
	        Reservation reservation = new Reservation(number, checkIn, checkOut);
	        System.out.println("Reservation: " + reservation);
	        
	        System.out.println();
	        System.out.println("Enter date to update the reservation: ");
	        System.out.print("Check-In date (dd/MM/yyyy): ");
	        checkIn = sdf.parse(scanner.next());
	        System.out.print("Check-Out date (dd/MM/yyyy): ");
	        checkOut = sdf.parse(scanner.next());
	        
	        reservation.updateDates(checkIn, checkOut);
	        System.out.println("Reservation: " + reservation);
        }catch(ParseException e) {
        	System.out.println("Invalid date format");
        }catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Unexpected error");//captura todo tipo de erro e faz um Upcasting para RuntimeException
		}
                         
        scanner.close();
	}

}
