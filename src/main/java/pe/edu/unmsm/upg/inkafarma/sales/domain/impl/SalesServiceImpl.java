package pe.edu.unmsm.upg.inkafarma.sales.domain.impl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pe.edu.unmsm.upg.inkafarma.sales.domain.service.SalesService;
import pe.edu.unmsm.upg.inkafarma.sales.query.SalesView;
import pe.edu.unmsm.upg.inkafarma.sales.query.SalesViewRepository;

@Component("salesService")
public class SalesServiceImpl implements SalesService {
	@Autowired
	private SalesViewRepository salesViewRepository;

	@Autowired
	@Qualifier("jdbcScheduler")
	private Scheduler jdbcScheduler;

	@Override
	public Mono<SalesView> getSaleById(String saleId) {
		Mono<SalesView> sale = Mono
							.defer(() -> Mono.just(this.salesViewRepository.findOneBySalesId(saleId) ))
							.subscribeOn(jdbcScheduler);
		return sale;
	}

	@Override
	public Flux<SalesView> findAll() {
		Flux<SalesView> defer = Flux.defer(() -> Flux.fromIterable(this.salesViewRepository.findAll()));
		return defer.subscribeOn(jdbcScheduler);
	}
}
