package userInfo;

import java.util.ArrayList;

//Class to handle the sign up and sign in functionality
public class Authorisation {
	
	//This will be my global variables
	private String username = null;
	private String userPassword = null;
	private ArrayList<String[]> arrUsers =null;

	
	public Authorisation(String username, String Password)
	{
		//The user input will be stored in the global variables
		this.username = username;
		this.userPassword = Password;
		this.arrUsers = new ArrayList<>();
	}
	
	public String registerUser(String username,String password)
	{
		//Check if the user input meets the minimum requirements
		if(this.CheckUserName() && this.checkPasswordComplexity())
		{
			String[] arrIndividualUser = {this.username,this.userPassword}; //Record the user info
			this.arrUsers.add(arrIndividualUser); 
			
			return  "welcome "+this.username;
		}else 
		{
			return "Username or password incorect, please try again.";
		}
				
	}
	
	private boolean CheckUserName() //Check if the user name meet the requirements
	{
		int countNameLength = this.username.length(); //The total length of the user name.
		if(username.contains("_") && countNameLength <5)
		{
			//user name contains an underscore and is no more than five characters long
			System.out.println("Username sucessfully captured.");
			return true;
		}else
		{
			//error message if does not meet the requirements
			System.err.println("Username is not correctly formatted; Please ensure that your username "
					+ "contains an underscore and is no more tha five characters in length.");
			return false;
		}
		
	}
	private boolean checkPasswordComplexity()
	{
		int countNameLength = this.userPassword.length(); //The total length of the user password.
		int countIndex = 0; //initial index of the string;
		
		//Sign up conditions
		boolean isCapitalFound =false;
		boolean hasNumber =false; //Has numbers
		boolean hasSpecialChar =false; //Has special characters
		
		//loop until all characters in the string are checked
		
		while(countIndex < countNameLength) 
		{
			//contains a capital letter
			char temPosition = userPassword.charAt(countIndex); //Current position of the character
			if(Character.isUpperCase(temPosition) ==true) //if Capital letter is found
			{
				isCapitalFound =true;
			}		
			if(Character.isDigit(temPosition)==true) //if its a number.
			{
				hasNumber =true; //Number found
				
			}
			if(Character.isLetterOrDigit(temPosition) ==true) //if its a number.
			{
				hasSpecialChar =true; //Number found	
			}
			
			countIndex++; //move to next position.
		}
		
		//Check if the password meets the the requirements combined.
		if(countNameLength > 8 && isCapitalFound ==true && hasNumber ==true && hasSpecialChar ==true)
		{ 
			//Correct format
			System.out.println("Password successfully captured.");
			return true;
		}else
		{
			System.out.println("Password is not correctly formatted;/n please ensure that "
					+ "the password contains at least eight charecters,a capital letter, "
					+ "a number and a special charecter.");
			return false;
		}
		
	}
	
	//Return the user information
	public String GetUserName()
	{
		return this.username;
	}
	public String GetPassword()
	{
		return this.userPassword;
	}
	public ArrayList<String[]> getUsers()
	{
		return this.arrUsers;
	}

}
