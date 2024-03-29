package pe.edu.unmsm.upg.inkafarma.sales.messages.commands
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import pe.edu.unmsm.upg.inkafarma.sales.domain.*;
import java.util.Date;

class RequestSalesOrderCommand(
	@TargetAggregateIdentifier val saleId: String,
	val customerId: Long,
	val details: List<SaleOrderDetail>
)

class DetailSaleOrderCommand(
	@TargetAggregateIdentifier val saleId: String
)

class MarkSalesOrderFailedCommand(
	@TargetAggregateIdentifier val saleId: String
)

class MarkSalesOrderCompletedCommand(
	@TargetAggregateIdentifier val saleId: String
)

class MarkDetailSalesOrderCompletedCommand(
	@TargetAggregateIdentifier val saleId: String
)