package pe.edu.unmsm.upg.inkafarma.accounts.messages.events

class SourceAccountDebitedEvent (
	val accountId: String,
	val amount: Double,
	val transactionId: String
)

class SourceAccountDebitRejectedEvent (
	val accountId: String,
	val transactionId: String
)

class SourceAccountNotFoundEvent (
	val accountId: String,
	val transactionId: String
)