package userInfo;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		boolean isRunning = true;
		do {
	try {
		
		///===============Chose if Your registering or login ================
		System.out.println("Press 1: Register or Press 2: Login or Press 3: Close program");
		Scanner UserChoise  = new Scanner(System.in); //User input
		String Selectedchoice = UserChoise.nextLine();
		Authorisation user = null;
		
		if(Selectedchoice.equals("1")) 
		{
			
			///======If pressed 1.====
			///===============Register user =================================
			
			
			
			//Get user name.
			System.out.println("Enter your name below:");
			Scanner Nameinput  = new Scanner(System.in);
			String name = Nameinput.nextLine();
			
			//Get last name
			System.out.println("Enter your Surname below:");
			Scanner Surnameinput  = new Scanner(System.in);
			String Surname = Surnameinput.nextLine();
			
			System.out.println("Enter your Email below:");
			Scanner EmailInput  = new Scanner(System.in);
			String Email = EmailInput.nextLine();
			
			//Get password.
			System.out.println("The password conditions. \n 1. Starts with a capital letter "
					+ "\n2. Has at least 5 characters \n3. Contains at least one number \n"
					+ "4. Contains at least one special character");
			System.out.println("Enter your password below:");
			Scanner PasswordInput  = new Scanner(System.in); 
			String password = PasswordInput.nextLine();
			
			       //Create user
					user = new Authorisation(name,Surname, Email, password);
					String message = user.registerUser();
					System.out.println(message);		

			//Close the stream input.
			Nameinput.close();
			Surnameinput.close();
			EmailInput.close();
			PasswordInput.close();
			
		}else if(Selectedchoice.equals("2")) //Login
		{
			//Get password.
			System.out.println("Enter your password below:");
			Scanner nameIn  = new Scanner(System.in); 
			String LogName = nameIn.nextLine();
			
			//Get password.
			System.out.println("Enter your password below:");
			Scanner passIn  = new Scanner(System.in); 
			String LogPass = passIn.nextLine();
			
		
				user.LoginUser(LogName, LogPass);
				nameIn.close();
				passIn.close();
			
		}else if(Selectedchoice.equals("3")) //close the program
		{
			isRunning =false;
			UserChoise.close();
		}else
		{
			
		}
		
		
		
	

	} catch (Exception e) {
	
	e.printStackTrace();
	}
		}while(isRunning);
}
}
