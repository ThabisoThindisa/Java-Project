package UserPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringController {

	private File FileObj = null;
	
	public StringController(File fileName)
	{
		//Uses the provided file name
		
		this.FileObj = fileName;	
	
	}
	
	public int CountSimCharacters(String charValue)
	{
		int count =0;

		Scanner scan = null;
		try {
			scan = new Scanner(this.FileObj);
			while((scan.hasNext())) //if the line is not empty
			{
				String CurrentLine =scan.nextLine();
				//If the character is found in the current line
				if(CurrentLine.contains(charValue)) 
				{
					count++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	
		
		return count;
	}
	
	public String ReverseTheWords()
	{
		String ResultDoc = "";
		
		Scanner scan = null;
		try {
			scan = new Scanner(this.FileObj);
			while((scan.hasNext())) //if the line is not empty
			{
				//the position of the last characters
				  String CurrentLine =scan.nextLine();
				  int lastCharPos = CurrentLine.length() -1; 

				  while(lastCharPos >=0)
				  {
					  ResultDoc += CurrentLine.charAt(lastCharPos); //String at this index	 
					  //Go to the next index
					  lastCharPos--;
				  }		
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return ResultDoc;
	}
	
	//Replace the Character with the new.
	 public String ReplaceString(String OldValue, String newValue) {
	        String ResultString = "";    

	        // Using try-with-resources to ensure Scanner is closed automatically
	        try (Scanner scan = new Scanner(FileObj)) {
	            while (scan.hasNext()) { // If the file has more lines
	                String currentLine = scan.nextLine();
	                
	                if (currentLine.contains(OldValue)) { // Check if the line contains the word to be replaced
	                    currentLine = currentLine.replaceAll(OldValue, newValue);
	                }
	                
	                ResultString += currentLine + "\n"; // Add new line for proper formatting
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        return ResultString;
	    }
	
	public File getFile()
	{
		return this.FileObj;
	}
	
}
