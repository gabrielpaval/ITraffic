package ro.proiect.iTraffic.Models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tarife")
public class Tarife implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tip", nullable = false)
    private String tip;

    @Column(name = "pret_copii", nullable = false)
    private Float pretCopii;

    @Column(name = "pret_elevi", nullable = false)
    private Float pretElevi;

    @Column(name = "pret_adulti", nullable = false)
    private Float pretAdulti;

    @Column(name = "pret_varstnici", nullable = false)
    private Float pretVarstnici;

}
