package userInfo;

import java.util.ArrayList;

//Class to handle the sign up and sign in functionality
public class Authorisation {
	
	//This will be my global variables
	private String UserName = null;
	private String UserSurname = null;
	private String userPassword = null;
	private String userEmail =null;
	
	private ArrayList<String[]> arrUsers =null;

	
	public Authorisation(String username,String USurname,String password, String UEmail)
	{
		//The user input will be stored in the global variables
		UserName = username;
		UserSurname = USurname;
		userPassword = password;
		userEmail =UEmail;
		arrUsers = new ArrayList<>();
	}
	
	public String registerUser()
	{
	   
		if(this.checkPasswordComplexity() && this.checkPersonalInfo()) //If successful.
		{
			String[] Userobj = new String[5];  //The users information  
			Userobj[0] = UserName;
			Userobj[1] = UserSurname;
			Userobj[2] = userEmail;
			Userobj[3] = userPassword;
			this.arrUsers.add(Userobj); //Save the information inside the list.
			return "Successfully registered:" + UserName +" "+ this.UserSurname; 
			
		}else {	
		return  "Unsuccessful registration";
		}
	}
	
	private boolean checkPersonalInfo() //Check if the user name meet the requirements
	{
	     if(!UserName.isBlank() || !UserSurname.isBlank() || !userEmail.isBlank())
	     {
	    	 return true; //Check if the name, surname and email is blank.
	     }else
	     {
	    	 return false; //Is empty or blank.
	     }
		
	}
	private boolean checkPasswordComplexity()
	{
		
		//The password conditions.
		//1. Starts with a capital letter
		//2. Has at least 5 characters
		//3. Contains at least one number
		//4. Contains at least one special character
		
		String pattern = "^[A-Z](?=.*\\d)(?=.*[^a-zA-Z0-9]).{4,}$";
		//===============================================================//
		
		if(this.userPassword.matches(pattern))
		{
			return true; //If it matches the requirements
		}else
		{
			return false; //Does not match.
		}
		
	}
	public boolean LoginUser(String email, String Password)
	{
		boolean userIsFound =false;
		if(!this.arrUsers.isEmpty()) //Check if the are users inside the array.
		{
			for(String[] tempUser : this.arrUsers )
			{
				if(tempUser[2].equals(email) && tempUser[3].equals(Password)) //If the info matches
				{
					userIsFound =true;
					System.out.println("Successfully login");
					
				}else //Does not match
				{
					System.out.println("Unsuccessfully login");
					return userIsFound; //
				}
			}
			
		}
		return userIsFound; //If no operation was performed

	}
	
	//Return the user information
	public String GetUserName()
	{
		return this.UserName;
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
