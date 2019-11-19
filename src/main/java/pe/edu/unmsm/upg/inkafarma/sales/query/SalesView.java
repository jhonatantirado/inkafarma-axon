package pe.edu.unmsm.upg.inkafarma.sales.query;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class SalesView {
	@Id
	@Column(length=36)
	private String salesId;
	private Date saleDate;
	private Long customerId;
	private int status;

	public SalesView() {
		
	}

	public SalesView(String salesId, Date saleDate, Long customerId, int status ) {
		this.salesId = salesId;
		this.saleDate = saleDate;
		this.customerId = customerId;
		this.status = status;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
}
