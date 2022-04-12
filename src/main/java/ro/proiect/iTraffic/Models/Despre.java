package ro.proiect.iTraffic.Models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="despre",schema = "public")
public class Despre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="prezentare")
    private String prezentare;

    @Column(name="conducere")
    private String conducere;

    @Column(name="busuri")
    private String busuri;

    @Column(name="email contact")
    private String email;

    @Column(name="numar telefon")
    private int numar;

    @Column(name="adresa contact")
    private String adresa;

}
