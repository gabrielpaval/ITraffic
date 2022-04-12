package ro.proiect.iTraffic.Models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="anunt",schema = "public")
public class Anunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nume")
    private String nume;

    @Column(name="descriere")
    private String descriere;

    @Column(name="data")
    private String data;

    @Column(name="intrebare")
    private String intrebare;

    @Column(name="email")
    private String email;

    @Column(name="raspuns")
    private String raspuns;


}
