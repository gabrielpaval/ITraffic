package ro.proiect.iTraffic.Models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="trasee",schema = "public")
public class Traseu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="linie")
    private String linie;


    @ElementCollection
    @JoinColumn(name="id_statii")
    private List<Long> id_statii;

    @JoinColumn(name="id_orare")
    private Long id_orare;





}
