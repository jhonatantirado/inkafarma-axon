package pe.edu.unmsm.upg.inkafarma.accounts.application.dto;

public class EditAccountErrorResponseDto {
	private String message;
	
	public EditAccountErrorResponseDto()
	{
		this.message = "Error Editing Account";
	}
	
	public String getMessage() {
		return message;
	}
}