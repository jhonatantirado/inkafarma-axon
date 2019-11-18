package pe.edu.unmsm.upg.inkafarma.sales.messages.events
import java.util.Date;
import pe.edu.unmsm.upg.inkafarma.sales.domain.Status

class SalesOrderRequestedEvent (
	val saleId: String,
	val customerId: String,
	val employeeId : String
)

class SalesOrderFailedEvent (
	val saleId: String
)

class SalesOrderCompletedEvent (
	val saleId: String,
	val saleDate: Date,
	val customerId: String,
	val employeeId : String,
	val status: Status
)

class DetailSalesOrderCompletedEvent (
	val saleId: String
)

class SalesOrderRejectedEvent (
	val saleId: String
)

