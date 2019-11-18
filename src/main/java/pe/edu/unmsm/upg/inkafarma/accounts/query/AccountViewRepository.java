package pe.edu.unmsm.upg.inkafarma.accounts.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountViewRepository extends JpaRepository<AccountView, String> {
    AccountView findOneByAccountId(String accountId);
}