package pe.edu.unmsm.upg.inkafarma.transfers.query;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import pe.edu.unmsm.upg.inkafarma.transfers.messages.events.*;

@Component
public class TranferHistoryProjection {
	private final TransferHistoryViewRepository transferHistoryViewRepository;
	
	public TranferHistoryProjection(TransferHistoryViewRepository transferHistoryViewRepository) {
        this.transferHistoryViewRepository = transferHistoryViewRepository;
    }
	
	@EventHandler
    public void on(MoneyTransferRequestedEvent event) {
		TransferHistoryView transferHistoryView = new TransferHistoryView(event.getTransactionId(), event.getSourceAccountId(), event.getDestinationAccountId(), event.getAmount());
		transferHistoryViewRepository.save(transferHistoryView);
    }
}
