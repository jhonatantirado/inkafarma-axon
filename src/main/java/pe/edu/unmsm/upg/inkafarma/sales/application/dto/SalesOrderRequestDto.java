package pe.edu.unmsm.upg.inkafarma.sales.application.dto;

import javax.validation.constraints.NotNull;

public class SalesOrderRequestDto {
	@NotNull
	private String customerId;
	private String employeeId;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	

}