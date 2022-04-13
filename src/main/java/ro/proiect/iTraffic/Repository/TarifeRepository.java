package ro.proiect.iTraffic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ro.proiect.iTraffic.Models.Tarife;

public interface TarifeRepository extends JpaRepository<Tarife, Long>, JpaSpecificationExecutor<Tarife> {

}