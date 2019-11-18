package pe.edu.unmsm.upg.inkafarma.transfers.messages.events

class MoneyTransferRequestedEvent (
	val transactionId: String,
	val sourceAccountId: String,
	val destinationAccountId: String,
	val amount: Double
)

class MoneyTransferFailedEvent (
	val transactionId: String
)

class MoneyTransferCompletedEvent (
	val transactionId: String
)
