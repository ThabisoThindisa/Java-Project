package userInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class HandleMessage {
	
	private String messageStr = "";
	private String cellNumber = "";
	private String Cellcode = "";
	private ArrayList<String> arrMessages; 
	
	public HandleMessage(String CellNumber)
	{
		this.cellNumber =CellNumber;
		this.arrMessages = new ArrayList<>();
	}
	public boolean checkMessageID()
	{ 
		
		if(this.messageStr.length() > 15 || this.messageStr.length() ==0)
		{
			return false; //if the message ID has more than 15 characters
		}else
		{
		
		return true; //Has enough characters  in the string.
		}
	}
	public String checkRecipientCell()
	{
		
		//Ensures that the recipient cell number is no more than 10 characters long.
		if(this.cellNumber.length() == 10 && this.cellNumber.startsWith("0"))
		{
			return "The Number: "+ this.cellNumber + " is Stored.";
		}else
		{
			return "Error: Incorrect Number format.";
		}

	}
	public String createMessageHash()
	{
		//The method creates and return the message Hash
		
	  int hashedCode = this.messageStr.hashCode();
		
		return String.valueOf(hashedCode);
	}
	@SuppressWarnings({ "unused", "resource" })
	public String sentMessage()
	{
		
		
		String functionOutcome ="";
	  try { 
		///Choose if you want to A) send, B) store and C)disregard the message
			System.out.println("Press the letters  \n "
					+ "A) send, "
					+ "B) store or "
					+ "C) disregard the message");
			
			Scanner userInput = new Scanner(System.in); //Get user input
			String getInput = userInput.nextLine(); //Read input
			String constantFormat = getInput.toUpperCase(); //Convert chose to upper case.
			
			if(constantFormat.equals("A"))
			{
				System.out.println("Enter your message.");
				Scanner ScanMessage = new Scanner(System.in); //Get user input
				String Messageinput = userInput.nextLine(); //Read input
				this.messageStr = Messageinput;
				this.arrMessages.add(this.messageStr); //Send the message
				
				functionOutcome ="Send";
				return functionOutcome;
				
			}else if(constantFormat.equals("B")) //Store the message
			{
				this.arrMessages.add(messageStr);
				functionOutcome ="Store";
				System.out.println("The message "+ this.messageStr+ " is stored.");
				userInput.close();
				return functionOutcome;
				
				
			}else if(constantFormat.equals("C")) //Disregard the message
			{
			      this.messageStr = "";	
			
			}else
			{
				System.out.println("You did not enter in the correct format.");
				functionOutcome ="Error";
				
			}
			
			userInput.close();
		  return functionOutcome;
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
		return functionOutcome;
	}

}
