package pe.edu.unmsm.upg.inkafarma.customers.application;

public class RegisterCustomerErrorResponseDto {
	private String message;
	
	public RegisterCustomerErrorResponseDto()
	{
		this.message = "Error Registering Customer";
	}
	
	public String getMessage() {
		return message;
	}
}