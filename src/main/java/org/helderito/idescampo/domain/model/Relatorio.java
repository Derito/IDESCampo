package org.helderito.idescampo.domain.model;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Relatorio extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	//@EqualsAndHashCode.Include
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;

    @Column(nullable = false)
    private String mes;    
   
    private OffsetDateTime dataRelatorio;

    private int totalHorasMes;
    private int numRevisitasMes;

    private int numEstudosMes;
    private int numLiteraturaMes;
    private int numVideosMes;
    private String observacoes;
       
   
    @ManyToOne     
    private Publicador publicador;    

}
