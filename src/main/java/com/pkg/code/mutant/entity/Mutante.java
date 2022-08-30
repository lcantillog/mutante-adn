package com.pkg.code.mutant.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HIS_MUTANTE")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Mutante {

    @Id
    @Column(name = "HMCODIGO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "HMFECACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "HMISMUTA")
    private Boolean isMutante;

    @Column(name = "HMSECMUT")
    private String secuencia;

}
