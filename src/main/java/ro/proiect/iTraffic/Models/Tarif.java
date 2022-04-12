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
@Table(name ="tarife",schema = "public")
public class Tarif {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="tip")
    private String tip;

    @Column(name="pret copii")
    private Double pretC;

    @Column(name="pret elevi")
    private Double pretE;

    @Column(name="pret adulti")
    private Double pretA;

    @Column(name="pret varstnici")
    private Double pretV;


}
