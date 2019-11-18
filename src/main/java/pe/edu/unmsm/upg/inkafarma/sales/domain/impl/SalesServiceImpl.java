package pe.edu.unmsm.upg.inkafarma.sales.domain.impl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pe.edu.unmsm.upg.inkafarma.sales.domain.repository.SalesRepository;
import pe.edu.unmsm.upg.inkafarma.sales.domain.service.SalesService;
import pe.edu.unmsm.upg.inkafarma.sales.query.SalesView;

@Component("salesService")
public class SalesServiceImpl implements SalesService {
	@Autowired
	private SalesRepository salesRepository;

	@Autowired
	@Qualifier("jdbcScheduler")
	private Scheduler jdbcScheduler;

	@Override
	public Mono<SalesView> getSaleById(String saleId) {
		Mono<SalesView> sale = Mono
							.defer(() -> Mono.just(this.salesRepository.findMonoById(saleId) ))
							.subscribeOn(jdbcScheduler);
		return sale;
	}

	@Override
	public Flux<SalesView> findAll() {
		Flux<SalesView> defer = Flux.defer(() -> Flux.fromIterable(this.salesRepository.findAll()));
		return defer.subscribeOn(jdbcScheduler);
	}
}
