package pe.edu.unmsm.upg.inkafarma.sales.domain;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.RequestSalesOrderCommand;
import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.MarkSalesOrderCompletedCommand;
import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.MarkSalesOrderFailedCommand;
import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.DetailSaleOrderCommand;
import pe.edu.unmsm.upg.inkafarma.sales.messages.commands.MarkDetailSalesOrderCompletedCommand;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.SalesOrderRequestedEvent;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.SalesOrderCompletedEvent;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.SalesOrderFailedEvent;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.DetailSalesOrderCompletedEvent;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.DetailSalesOrderRequestEvent;



@Aggregate
public class SalesOrder {
	@AggregateIdentifier
	private String saleId;
	@SuppressWarnings("unused")
	private Date saleDate;
	@SuppressWarnings("unused")
	private long customerId;
	@SuppressWarnings("unused")
	private Status status;
	@SuppressWarnings("unused")
	private List<SaleOrderDetail> details;
	
	public SalesOrder() {
		details = null;
	}
	
	@CommandHandler
    public SalesOrder(RequestSalesOrderCommand command) {
        apply(
        	new SalesOrderRequestedEvent(
        		command.getSaleId(),
        		command.getCustomerId(),
        		command.getDetails()
        	)
        );
    }
	
	@CommandHandler
    public void handle(MarkSalesOrderCompletedCommand command) {
        apply(new SalesOrderCompletedEvent(command.getSaleId(), this.saleDate, this.customerId, this.status ));
    }
	
	@CommandHandler
    public void handle(MarkDetailSalesOrderCompletedCommand command) {
		for(SaleOrderDetail detail : details) {
			detail.setDetailId(UUID.randomUUID().toString());
			detail.setSaleId(command.getSaleId());
		}
        apply(new DetailSalesOrderCompletedEvent(command.getSaleId(), this.details ));
    }
	
	@CommandHandler
    public void handle(DetailSaleOrderCommand command) {		
        apply(new DetailSalesOrderRequestEvent(command.getSaleId() ));
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
        this.details = event.getDetails();     
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
