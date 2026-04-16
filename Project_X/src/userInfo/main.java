package userInfo;

import java.util.Scanner;

public class main {

	@SuppressWarnings("resource")
	public static Authorisation HandleAuthorisation(String Selectedchoice)
	{
		///===============Chose if Your registering or login ================
		
		Authorisation user = null;
		
		if(Selectedchoice.equals("1")) 
		{
			
			///======If pressed 1.====
			System.out.println("============= Register user ===============");
			
				//Get user name.
				System.out.println("Enter your name below:");
				Scanner Nameinput  = new Scanner(System.in);
				String name = Nameinput.nextLine();
				
				//Get last name
				System.out.println("Enter your Surname below:");
				Scanner Surnameinput  = new Scanner(System.in);
				String Surname = Surnameinput.nextLine();
				
				//get user email
				System.out.println("Enter your Email below:");
				Scanner EmailInput  = new Scanner(System.in);
				String Email = EmailInput.nextLine();
				
				//Get password.
				System.out.println("The password conditions. \n 1. Starts with a capital letter "
						+ " and has at least 5 characters \n3. 2. Contains at least one number and "
						+ "Contains at least one special character");
				
				System.out.println("Enter your password below:");
				Scanner PasswordInput  = new Scanner(System.in); 
				String password = PasswordInput.nextLine();
				
				       //Create user
						user = new Authorisation(name,Surname, Email, password);
						String message = user.registerUser();
					    System.out.println("Registration: "+message);	
					   
					    
					    //If the registration is successful then switch to login
					    if(message.startsWith("Successfully registered:"))
					    {
					    	Selectedchoice ="2";
					    }
					   
			
		}
		
		if(Selectedchoice.equals("2")) //Login
		{
			//Get password.
			System.out.println("\n=============== Login =============");
			System.out.println("Enter your email below:");
			Scanner nameIn  = new Scanner(System.in); 
			String LogName = nameIn.nextLine();
			
			//Get password.
			System.out.println("Enter your password below:");
			Scanner passIn  = new Scanner(System.in); 
			String LogPass = passIn.nextLine();
			
		
				boolean isLogged = user.LoginUser(LogName, LogPass);
				if(isLogged)
				{
					System.out.println("Successful login");
				}else
				{
					System.out.println("Error:Unsuccessful login");
				}
			 
		}
		

		return user;
		
	}
	
	public static void main(String[] args) {
		
		boolean isRunning = true;
		do {
	try {
		///===============Chose if Your registering or login ================
		System.out.println("Press 1: Register user or Press 2: Login or Press 3: Close program");
		Scanner UserChoise  = new Scanner(System.in); //User input
		String Selectedchoice = UserChoise.nextLine();
	
		if(Selectedchoice.equals("1") || Selectedchoice.equals("2") || Selectedchoice.equals("3"))
		{
			//If user chooses 1: Register or 2:Login
			Authorisation user = HandleAuthorisation(Selectedchoice);
			
			//if user is successfully logged in the start sending messages.
			if(user.RecordLogStatus())
			{
				System.out.println("\n=========== Messanger ===========");
				System.out.println("Enter your cell number below:");
				Scanner Cell_Input  = new Scanner(System.in);
				String CellNumber = Cell_Input.nextLine();
				HandleMessage UserMessanger = new HandleMessage(CellNumber);
				String number = UserMessanger.checkRecipientCell();
				System.out.println(number);
				
				//Repeat until the user wants to stop.
				boolean isSending = true;
				while(isSending)
				{
					
					UserMessanger.sentMessage();
					
					
					
				}
				
					
			}
			
			if(Selectedchoice.equals("3")) //close the program
			{
				System.out.println("The Application has been successfully been stopped.");
				isRunning =false;			
			}	
		}else
		{
			System.out.println("Error: Incorrect input format, Try again");	
		}

		System.out.println("===========================================");
		
	} catch (Exception e) {
	
	e.printStackTrace();
	}
		}while(isRunning);
}
}
