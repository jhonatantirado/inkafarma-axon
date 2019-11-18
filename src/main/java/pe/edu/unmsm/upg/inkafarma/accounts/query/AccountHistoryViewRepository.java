package pe.edu.unmsm.upg.inkafarma.accounts.query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHistoryViewRepository extends JpaRepository<AccountHistoryView, String> {
    
}
