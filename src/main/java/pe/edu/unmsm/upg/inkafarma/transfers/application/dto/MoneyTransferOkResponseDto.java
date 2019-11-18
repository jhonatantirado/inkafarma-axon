package pe.edu.unmsm.upg.inkafarma.transfers.application.dto;

public class MoneyTransferOkResponseDto {
	private String transactionId;
	
	public MoneyTransferOkResponseDto(String transactionId)
	{
		this.transactionId = transactionId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
}