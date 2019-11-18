package pe.edu.unmsm.upg.inkafarma.sales.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.unmsm.upg.inkafarma.sales.query.SalesView;

public interface SalesRepository extends CrudRepository<SalesView, Long> {
	SalesView findMonoById(String salesId);

}
