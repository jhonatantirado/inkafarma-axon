package pe.edu.unmsm.upg.inkafarma.sales.domain.service;

import pe.edu.unmsm.upg.inkafarma.sales.query.SalesView;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SalesService {
	Mono<SalesView> getSaleById(String saleId);
	Flux<SalesView> findAll();
}
