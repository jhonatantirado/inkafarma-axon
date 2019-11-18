package pe.edu.unmsm.upg.inkafarma.customers.messages.events

class CustomerRegisteredEvent (
	val customerId: String,
	val firstName: String,
	val lastName: String,
	val identityDocumentNumber: String
)

class CustomerEditedEvent (
	val customerId: String,
	val firstName: String,
	val lastName: String,
	val identityDocumentNumber: String
)