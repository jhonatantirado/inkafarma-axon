package pe.edu.unmsm.upg.inkafarma.customers.messages.commands;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

class RegisterCustomerCommand(
	@TargetAggregateIdentifier val customerId: String,
	val firstName : String,
	val lastName: String,
	val identityDocumentNumber : String
)

class EditCustomerCommand(
	@TargetAggregateIdentifier val customerId: String,
	val firstName : String,
	val lastName: String,
	val identityDocumentNumber : String
)