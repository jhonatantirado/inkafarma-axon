package pe.edu.unmsm.upg.inkafarma.accounts.messages.events

class DestinationAccountCreditedEvent (
	val accountId: String,
	val amount: Double,
	val transactionId: String
)

class DestinationAccountNotFoundEvent (
	val accountId: String,
	val transactionId: String
)