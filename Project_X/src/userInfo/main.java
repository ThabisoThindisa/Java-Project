package userInfo;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
	try {
		
		
		//Get user name.
		System.out.println("What is the username");
		Scanner Nameinput  = new Scanner(System.in);
		String username = Nameinput.nextLine();
		
		//Get password.
		System.out.println("What is the password");
		Scanner PasswordInput  = new Scanner(System.in);
		String password = PasswordInput.nextLine();
		
		if(username !=null && password != null)  //While not void
		{
		       //Create user
				Authorisation user = new Authorisation(username,password);
				String message = user.registerUser(username, password);
				System.out.println(message);
				
			
		}
		
		//Close the stream input.
		Nameinput.close();
		PasswordInput.close();
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
