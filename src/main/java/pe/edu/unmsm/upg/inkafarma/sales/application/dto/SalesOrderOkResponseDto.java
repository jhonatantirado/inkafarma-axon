package pe.edu.unmsm.upg.inkafarma.sales.application.dto;

public class SalesOrderOkResponseDto {
	private String salesId;
	
	public SalesOrderOkResponseDto(String salesId)
	{
		this.salesId = salesId;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
		
}