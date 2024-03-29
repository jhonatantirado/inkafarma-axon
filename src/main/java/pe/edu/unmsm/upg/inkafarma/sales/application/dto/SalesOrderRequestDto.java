package pe.edu.unmsm.upg.inkafarma.sales.application.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import pe.edu.unmsm.upg.inkafarma.sales.domain.SaleOrderDetail;

public class SalesOrderRequestDto {
	@NotNull
	private Long customerId;
	private List<SaleOrderDetail> details;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public List<SaleOrderDetail> getDetails() {
		return details;
	}
	public void setDetails(List<SaleOrderDetail> details) {
		this.details = details;
	}
	
}