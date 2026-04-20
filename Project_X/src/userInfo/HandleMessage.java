package userInfo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HandleMessage {
	
	private String messageStr = null;
	private String cellNumber = "";
	private String generatedID  ="";
	
	private ArrayList<String[]> List_Messages; 
	
	public HandleMessage(String CellNumber)
	{
		this.cellNumber =CellNumber;
		this.List_Messages = new ArrayList<>();
	}
	public boolean checkMessageID()
	{ 
		int messIDSize =this.messageStr.length();
		if(messIDSize > 15 || messIDSize ==0)
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
		if(this.cellNumber.length() == 12 && this.cellNumber.startsWith("+27"))
		{
			String message = "The Number: "+ this.cellNumber + " is Stored.";
			System.out.println(message);
			return message;
		}else
		{
			String message = "Error: Incorrect Number format.";
			System.err.println(message);
			return message;
		}

	}
	public String createMessageHash()
	{
		//The method creates and return the message Hash
		
		
		String hashmassage =String.valueOf(this.generatedID)+":"+String.valueOf("");
		
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
				messageStr = Messageinput;
				
				long messageID = ThreadLocalRandom.current()
		                .nextLong(1_000_000_000L, 10_000_000_000L); //Randomly generate a 10 digit number
				
				generatedID = String.valueOf(messageID); //Convert long to string value
				
				//Store the values
				
				String[] arrayMess = new String[2];
				arrayMess[0] =generatedID; //ID
				arrayMess[1] =messageStr;  //Message
				
				List_Messages.add(arrayMess); //Send the message
				
				functionOutcome ="Send: "+ messageStr;
				return functionOutcome;
				
			}else if(constantFormat.equals("B")) //Store the message
			{
				String[] arrayMess = new String[2];
				arrayMess[0] =generatedID; //ID
				arrayMess[1] =messageStr;  //Message
				
				this.List_Messages.add(arrayMess);
				functionOutcome ="Store";
				System.out.println("The message "+ messageStr+ " is stored.");
				
				return functionOutcome;
	
			}else if(constantFormat.equals("C")) //Disregard the message
			{
			      messageStr = "";	
			
			}else
			{
				System.err.println("You did not enter in the correct format.");
				functionOutcome ="Error";		
			}
			
		  return functionOutcome;
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
		return functionOutcome;
	}
	public String printMessage()
	{
		//Displays all the messages that where send during runtime
		String messages ="";
		if(List_Messages.isEmpty())
		{
			return "No available messages";
		}else
		{
			for(String[] currentMessage : this.List_Messages) //get all the messages
			{
				messages +=currentMessage[1] +"\n"; //
			}
		}
		
		return messages;
		
	}
	public String returnTotalMessages()
	{
		//Get the total number of send messages
		if(this.List_Messages.isEmpty()) //No available messages
		{
			return "0";
		}
		else
		{
			String numMessages = String.valueOf(List_Messages.size()); 
			return numMessages;
		}
	}
	

}
