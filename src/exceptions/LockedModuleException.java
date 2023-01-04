package exceptions;

public class LockedModuleException extends Exception{
	
	
	
	public LockedModuleException(String message) {
		super(message);
	}
	
	public  void PrintMessage(String str) {
		System.out.println(str);
	}

}
