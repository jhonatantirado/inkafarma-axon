package pe.edu.unmsm.upg.inkafarma.sales.sagas;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.*;
import pe.edu.unmsm.upg.inkafarma.transfers.messages.commands.MarkMoneyTransferCompletedCommand;
import pe.edu.unmsm.upg.inkafarma.transfers.messages.commands.MarkMoneyTransferFailedCommand;
import pe.edu.unmsm.upg.inkafarma.accounts.messages.events.DestinationAccountCreditedEvent;
import pe.edu.unmsm.upg.inkafarma.accounts.messages.events.SourceAccountDebitRejectedEvent;
import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.*;
import javax.inject.Inject;
import java.util.Date;

@Saga
public class SalesOrderSaga {
	private String customerId;
	private String employeeId;
	
	@Inject
    private transient CommandGateway commandGateway;
	
	@StartSaga
    @SagaEventHandler(associationProperty = "saleId")
    public void on(SalesOrderRequestedEvent event) {
		this.customerId = event.getCustomerId();
        this.employeeId = event.getEmployeeId();                       
		
		DetailSaleOrderCommand command = new DetailSaleOrderCommand(event.getSaleId());
		commandGateway.send(command);
		 
	}
	
	@SagaEventHandler(associationProperty = "saleId")
    @EndSaga
    public void on(SalesOrderRejectedEvent event) {
		MarkSalesOrderFailedCommand command = new MarkSalesOrderFailedCommand(event.getSaleId());
		commandGateway.send(command);
    }
	
	@EndSaga
    @SagaEventHandler(associationProperty = "saleId")
    public void on(DetailSalesOrderCompletedEvent event) {
        MarkSalesOrderCompletedCommand command = new MarkSalesOrderCompletedCommand(event.getSaleId());
        commandGateway.send(command);
        
    }
	
}
