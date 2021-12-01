// ITCS
// 02.23.2021
// Harish Viswa

import java.util.Scanner;

public class ConvertToDMY {

	public static void main(String[] args) {
		
		//Create a scanner object
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a total number of days: ");
		int x = scan.nextInt();

		System.out.println(x+" days is " + convert(x));
		
		scan.close();
		

	}
	
	public static String convert(int days) {
		int years = days/365;
		days = days%365;
		int months = days/12;
		days = days%12;
		int day = days;
		return years + " years, " + months + " months, and " + day + " days.";
	}
		
	}
	

