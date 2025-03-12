package UserPackage;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringController controller = new StringController(new File("Files/Taking notes.txt"));
		//int value = controller.CountSimCharacters("a");
		//System.out.println(value);
		System.out.println(controller.getFile().getAbsolutePath());
		System.out.println( controller.CountSimCharacters("condense"));
	
	}

}
