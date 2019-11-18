package pe.edu.unmsm.upg.inkafarma.sales.query;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import pe.edu.unmsm.upg.inkafarma.sales.messages.events.*;
import pe.edu.unmsm.upg.inkafarma.sales.domain.SaleOrderDetail;

@Component
public class DetailSaleProjection {
	private final DetailSaleViewRepository detailSaleViewRepository;
	
	public DetailSaleProjection(DetailSaleViewRepository detailSaleViewRepository) {
        this.detailSaleViewRepository = detailSaleViewRepository;
    }
	
	@EventHandler
    public void on(DetailSalesOrderCompletedEvent event) {
		for(SaleOrderDetail detail:  event.getDetails()) {
			DetailSaleView detailView = new DetailSaleView(detail.getDetailId(), detail.getSaleId(), detail.getProductId(), detail.getQuantity(), detail.getPrice(), detail.getCurrency() );
			detailSaleViewRepository.save(detailView);
		}
		
    }
}
