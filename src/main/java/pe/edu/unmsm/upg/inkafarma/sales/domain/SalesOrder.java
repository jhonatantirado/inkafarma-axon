package pe.edu.unmsm.upg.inkafarma.sales.domain;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import java.util.Date;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.RequestSalesOrderCommand;
import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.MarkSalesOrderCompletedCommand;
import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.MarkSalesOrderFailedCommand;
import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.DetailSaleOrderCommand;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.SalesOrderRequestedEvent;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.SalesOrderCompletedEvent;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.SalesOrderFailedEvent;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.DetailSalesOrderCompletedEvent;


@Aggregate
public class SalesOrder {
	@AggregateIdentifier
	private String saleId;
	@SuppressWarnings("unused")
	private Date saleDate;
	@SuppressWarnings("unused")
	private String customerId;
	@SuppressWarnings("unused")
	private String employeeId;
	@SuppressWarnings("unused")
	private Status status;
	
	public SalesOrder() {
	}
	
	@CommandHandler
    public SalesOrder(RequestSalesOrderCommand command) {
        apply(
        	new SalesOrderRequestedEvent(
        		command.getSaleId(),
        		command.getCustomerId(),
        		command.getEmployeeId()
        	)
        );
    }
	
	@CommandHandler
    public void handle(MarkSalesOrderCompletedCommand command) {
        apply(new SalesOrderCompletedEvent(command.getSaleId(), this.saleDate, this.customerId, this.employeeId, this.status ));
    }
	
	@CommandHandler
    public void handle(DetailSaleOrderCommand command) {
        apply(new DetailSalesOrderCompletedEvent(command.getSaleId() ));
    }
	
	@CommandHandler
    public void handle(MarkSalesOrderFailedCommand command) {
        apply(new SalesOrderFailedEvent(command.getSaleId()));
    }
	
	@EventSourcingHandler
    protected void on(SalesOrderRequestedEvent event) {
        this.saleId = event.getSaleId();
        this.saleDate = new Date();
        this.customerId = event.getCustomerId();
        this.employeeId = event.getEmployeeId();
        this.status = Status.STARTED;
    }
	
	@EventSourcingHandler
    public void on(SalesOrderCompletedEvent event) {
        this.status = Status.COMPLETED;
    }
	
	@EventSourcingHandler
    public void on(SalesOrderFailedEvent event) {
        this.status = Status.FAILED;
    }
	
}
