package it.epicode.racheleburgio.Viaggio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "dipendenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinazione;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String stato;
}
