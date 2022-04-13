package ro.proiect.iTraffic.Models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "trasee")
public class Trasee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "linie", nullable = false)
    private String linie;

    @Column(name = "id_orare", nullable = false)
    private Long idOrare;

    @Column(name = "id_statii")
    private String idStatii;

}
