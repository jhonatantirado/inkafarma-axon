package pe.edu.unmsm.upg.inkafarma.sales.query;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetailSaleView {
	@Id
	@Column(length=36)
	private String detailId;
	private String salesId;
	private Long productId;
	private int quantity;
	private int price;
	private String currency;
		
	public DetailSaleView() {
		
	}

	public DetailSaleView(String detailId, String salesId, Long productId, int quantity, int price, String currency) {
		super();
		this.detailId = detailId;
		this.salesId = salesId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.currency = currency;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
