package pe.edu.unmsm.upg.inkafarma.accounts.messages.events

class MoneyOfFailedMoneyTransferReturnedEvent (
	val accountId: String,
	val amount: Double,
	val transactionId: String
)