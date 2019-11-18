package pe.edu.unmsm.upg.inkafarma.sales.query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DetailSaleViewRepository extends JpaRepository<DetailSaleView, String> {
    
}
