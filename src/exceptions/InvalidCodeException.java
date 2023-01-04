package exceptions;

public class InvalidCodeException extends Exception{
	
	private String code;
	
	public InvalidCodeException(String code, String message) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
		
	}

}
