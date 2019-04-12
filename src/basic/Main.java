package basic;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		System.out.println("Enter First Number");
		int number1=s.nextInt();
		
		
		System.out.println("Enter second Number");
		int number2=s.nextInt();
		
		System.out.println("Choices are....");
		System.out.println("Enter second Number");
		System.out.println("1-Add");
		System.out.println("2-Subtract");
		System.out.println("3-Multiply");
		System.out.println("4-Divide");
		System.out.println("Enter your choice");
		
		int choice=s.nextInt();
		Calculator c=new Calculator();
		switch(choice) {
		case 1: c.sum(number1,number2);
				break;
		case 2: c.subtract(number1,number2);
		break;
		case 3: c.multiply(number1,number2);
		break;
		case 4: c.divide(number1,number2);
		break;
		default:System.out.println("Invalid input");
	}

}
}
