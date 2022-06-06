package ro.proiect.iTraffic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ro.proiect.iTraffic.Models.Trasee;

public interface TraseeRepository extends JpaRepository<Trasee, Long>, JpaSpecificationExecutor<Trasee> {
    int countById(Long id);
}