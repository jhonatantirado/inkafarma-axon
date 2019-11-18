package pe.edu.unmsm.upg.inkafarma.sales.messages.events
import java.util.Date;
import pe.edu.unmsm.upg.inkafarma.sales.domain.Status
import pe.edu.unmsm.upg.inkafarma.sales.domain.SaleOrderDetail

class SalesOrderRequestedEvent (
	val saleId: String,
	val customerId: Long,
	val employeeId : Long,
	val details: List<SaleOrderDetail>
)

class SalesOrderFailedEvent (
	val saleId: String
)

class SalesOrderCompletedEvent (
	val saleId: String,
	val saleDate: Date,
	val customerId: Long,
	val employeeId : Long,
	val status: Status
)

class DetailSalesOrderRequestEvent (
	val saleId: String
)

class DetailSalesOrderCompletedEvent (
	val saleId: String,
	val details: List<SaleOrderDetail>
)

class SalesOrderRejectedEvent (
	val saleId: String
)

