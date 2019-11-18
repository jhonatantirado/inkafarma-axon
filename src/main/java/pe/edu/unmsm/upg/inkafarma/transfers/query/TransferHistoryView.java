package pe.edu.unmsm.upg.inkafarma.transfers.query;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransferHistoryView {
	@Id
	@Column(length=36)
	private String transactionId;
	private String sourceAccountId;
	private String destinationAccountId;
	private double amount;	
		
	public TransferHistoryView() {
		
	}

	public TransferHistoryView(String transactionId, String sourceAccountId, String destinationAccountId,
			double amount) {
		this.transactionId = transactionId;
		this.sourceAccountId = sourceAccountId;
		this.destinationAccountId = destinationAccountId;
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(String sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public String getDestinationAccountId() {
		return destinationAccountId;
	}

	public void setDestinationAccountId(String destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
