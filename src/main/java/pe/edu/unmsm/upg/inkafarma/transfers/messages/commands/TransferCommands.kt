package pe.edu.unmsm.upg.inkafarma.transfers.messages.commands;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

class RequestMoneyTransferCommand(
	@TargetAggregateIdentifier val transactionId: String,
	val sourceAccountId : String,
	val destinationAccountId: String,
	val amount : Double
)

class CreditDestinationAccountCommand(
	@TargetAggregateIdentifier val accountId: String,
	val transactionId: String,
	val amount: Double
)

class MarkMoneyTransferFailedCommand(
	@TargetAggregateIdentifier val transactionId: String
)

class MarkMoneyTransferCompletedCommand(
	@TargetAggregateIdentifier val transactionId: String
)