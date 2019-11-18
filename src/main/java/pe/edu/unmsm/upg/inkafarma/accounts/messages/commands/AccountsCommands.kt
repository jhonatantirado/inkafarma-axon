package pe.edu.unmsm.upg.inkafarma.accounts.messages.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

class DepositMoneyCommand(
	@TargetAggregateIdentifier val accountId: String,
	val transactionId : String,
	val amount: Double
)

class WithdrawMoneyCommand(
	@TargetAggregateIdentifier val accountId: String,
	val transactionId : String,
	val amount: Double
)

class CreditDestinationAccountCommand(
	@TargetAggregateIdentifier val accountId: String,
	val transferId : String,
	val amount: Double
)

class DebitSourceAccountCommand(
	@TargetAggregateIdentifier val accountId: String,
	val transferId : String,
	val amount: Double
)

class EditAccountCommand(
	@TargetAggregateIdentifier val accountId: String,
	val overdraftLimit: Double
)

class OpenAccountCommand(
	@TargetAggregateIdentifier val accountId: String,
	val overdraftLimit: Double,
	val customerId: String
)

class ReturnMoneyOfFailedMoneyTransferCommand(
	@TargetAggregateIdentifier val accountId: String,
	val transferId: String,
	val amount: Double
)
