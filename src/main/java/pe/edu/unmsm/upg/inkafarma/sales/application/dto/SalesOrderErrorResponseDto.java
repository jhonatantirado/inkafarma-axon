package pe.edu.unmsm.upg.inkafarma.sales.application.dto;

public class SalesOrderErrorResponseDto {
	private String message;
	
	public SalesOrderErrorResponseDto()
	{
		this.message = "Error with the sale order";
	}
	
	public SalesOrderErrorResponseDto(String message)
	{
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}