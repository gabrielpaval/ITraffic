package ro.proiect.iTraffic.Models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "anunturi")
public class Anunturi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "descriere", nullable = false)
    private String descriere;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "intrebare")
    private String intrebare;

    @Column(name = "email")
    private String email;

    @Column(name = "raspuns")
    private String raspuns;

}
