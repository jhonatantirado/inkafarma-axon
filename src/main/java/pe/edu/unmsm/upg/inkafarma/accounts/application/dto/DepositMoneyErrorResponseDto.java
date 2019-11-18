package pe.edu.unmsm.upg.inkafarma.accounts.application.dto;

public class DepositMoneyErrorResponseDto {
	private String message;
	
	public DepositMoneyErrorResponseDto()
	{
		this.message = "Error with the deposit";
	}
	
	public DepositMoneyErrorResponseDto(String message)
	{
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}