package pe.edu.unmsm.upg.inkafarma.accounts.messages.events

class AccountEditedEvent (
	val accountId: String,
	val overdraftLimit: Double
)

class AccountOpenedEvent (
	val accountId: String,
	val overdraftLimit: Double,
	val customerId: String
)