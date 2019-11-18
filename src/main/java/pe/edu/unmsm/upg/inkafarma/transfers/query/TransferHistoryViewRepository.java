package pe.edu.unmsm.upg.inkafarma.transfers.query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.unmsm.upg.inkafarma.transfers.query.TransferHistoryView;

@Repository
public interface TransferHistoryViewRepository extends JpaRepository<TransferHistoryView, String> {
    
}
