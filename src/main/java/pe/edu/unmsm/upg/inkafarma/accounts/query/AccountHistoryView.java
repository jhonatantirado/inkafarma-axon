package pe.edu.unmsm.upg.inkafarma.accounts.query;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountHistoryView {
	@Id
	@Column(length=36)
    private String transactionId;
	private String accountId;
    private double amount;

    public AccountHistoryView() {
    }

	public AccountHistoryView(String transactionId, String accountId, double amount) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
