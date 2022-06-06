package ro.proiect.iTraffic.Models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;

@Data
@Entity
@Table(name = "orare")
public class Orare implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "program")
    private String program;

    @Column(name = "incepe_la")
    private Time incepeLa;

    @Column(name = "termina_la")
    private Time terminaLa;

}
