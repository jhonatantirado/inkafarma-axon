package pe.edu.unmsm.upg.inkafarma.sales.query;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import java.util.Date;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.*;

@Component
public class SalesProjection {
	private final SalesViewRepository salesViewRepository;
	
	public SalesProjection(SalesViewRepository salesViewRepository) {
        this.salesViewRepository = salesViewRepository;
    }
	
	@EventHandler
    public void on(SalesOrderCompletedEvent event) {
		SalesView salesView = new SalesView(event.getSaleId(), event.getSaleDate(), event.getCustomerId(), 1);
		salesViewRepository.save(salesView);
    }
}
