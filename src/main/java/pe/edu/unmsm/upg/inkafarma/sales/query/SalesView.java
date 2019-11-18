package pe.edu.unmsm.upg.inkafarma.sales.query;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import pe.edu.unmsm.upg.inkafarma.sales.domain.Status;

import java.util.Date;

@Entity
public class SalesView {
	@Id
	@Column(length=36)
	private String salesId;
	private Date saleDate;
	private String customerId;
	private String employeeId;
	private Status status;
		
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public SalesView() {
		
	}

	public SalesView(String salesId, Date saleDate, String customerId, String employeeId, Status status ) {
		this.salesId = salesId;
		this.saleDate = saleDate;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.status = status;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

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

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

}
