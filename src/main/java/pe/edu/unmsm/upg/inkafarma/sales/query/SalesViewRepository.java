package pe.edu.unmsm.upg.inkafarma.sales.query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.unmsm.upg.inkafarma.sales.query.SalesView;

@Repository
public interface SalesViewRepository extends JpaRepository<SalesView, String> {
	SalesView findOneBySalesId(String salesId);
}
