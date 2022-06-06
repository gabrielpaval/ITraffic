package ro.proiect.iTraffic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ro.proiect.iTraffic.Models.Statii;

public interface StatiiRepository extends JpaRepository<Statii, Long>, JpaSpecificationExecutor<Statii> {

}