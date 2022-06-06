package ro.proiect.iTraffic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ro.proiect.iTraffic.Models.Orare;

public interface OrareRepository extends JpaRepository<Orare, Long>, JpaSpecificationExecutor<Orare> {

}