import java.util.Scanner;

public class MultiplicationTable {
	public static void main (String args[]){
		//creation of scanner object
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the size of the multuplication table: ");
		//storing input of user as an integer
		Integer input = scan.nextInt();
		//creation of table using user input
		int table[][]=new int[input][input];
		int row=1;
		int column=1;
		//performing math for the table
		for(int i=0; i<table.length; i++){
		   for(int j=0; j<table[i].length; j++){
		     table[i][j]=row*column;
		     column=column+1;
		}
		row=row+1;
		column=1;
		}
		//creation and display of the table
		for(int i=0; i<table.length; i++){
		   for(int j=0; j<table[i].length; j++){
		     System.out.print(" "+table[i][j]+"\t");
		}
		System.out.print("\n");
		}
		}
		}

