package ro.proiect.iTraffic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ro.proiect.iTraffic.Models.Anunturi;

public interface AnunturiRepository extends JpaRepository<Anunturi, Long>, JpaSpecificationExecutor<Anunturi> {

}