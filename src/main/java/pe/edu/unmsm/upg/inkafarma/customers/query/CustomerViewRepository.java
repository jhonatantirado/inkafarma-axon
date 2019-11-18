package pe.edu.unmsm.upg.inkafarma.customers.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerViewRepository extends JpaRepository<CustomerView, String> {
	CustomerView findOneByCustomerId(String customerId);
}