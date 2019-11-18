package pe.edu.unmsm.upg.inkafarma.accounts.query;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import pe.edu.unmsm.upg.inkafarma.accounts.messages.events.*;

@Component
public class AccountHistoryViewProjection {
	private final AccountHistoryViewRepository accountHistoryViewRepository;
	
	public AccountHistoryViewProjection(AccountHistoryViewRepository accountHistoryViewRepository) {
        this.accountHistoryViewRepository = accountHistoryViewRepository;
    }
	
	@EventHandler
    public void on(AccountOpenedEvent event) {
		AccountHistoryView accountView = new AccountHistoryView(event.getAccountId(),event.getAccountId(), 0.00);
		accountHistoryViewRepository.save(accountView);
    }
	
	@EventHandler
    public void on(MoneyDepositedEvent event) {
		//AccountView accountView = accountViewRepository.findOneByAccountId(event.getAccountId());
		AccountHistoryView accountHistoryView = new AccountHistoryView(event.getTransactionId(), event.getAccountId(), event.getAmount());
		accountHistoryViewRepository.save(accountHistoryView);
    }
	
	@EventHandler
    public void on(MoneyWithdrawnEvent event) {
		AccountHistoryView accountHistoryView = new AccountHistoryView(event.getTransactionId(), event.getAccountId(), (event.getAmount()*-1) );
		accountHistoryViewRepository.save(accountHistoryView);
    }
	
	@EventHandler
    public void on(SourceAccountDebitedEvent event) {
		AccountHistoryView accountHistoryView = new AccountHistoryView(event.getTransactionId(), event.getAccountId(), (event.getAmount()*-1) );
		accountHistoryViewRepository.save(accountHistoryView);
    }
	
	@EventHandler
    public void on(DestinationAccountCreditedEvent event) {
		AccountHistoryView accountHistoryView = new AccountHistoryView(event.getTransactionId(), event.getAccountId(), event.getAmount());
		accountHistoryViewRepository.save(accountHistoryView);
    }
}
