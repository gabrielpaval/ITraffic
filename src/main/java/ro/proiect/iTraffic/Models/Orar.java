package ro.proiect.iTraffic.Models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="orare",schema = "public")
public class Orar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ElementCollection
    @Column(name = "orar luni vineri")
    private List<String> orarLV;

    @ElementCollection
    @Column(name="orar sambata")
    private List<String> orarS;

    @ElementCollection
    @Column(name="orar duminica")
    private List<String> orarD;



}
