package org.helderito.idescampo.domain.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Publicador implements Serializable{

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
   
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	
	 @Column(nullable = false, unique = true)
	 @NotBlank
	 private String email;

	@CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private OffsetDateTime dataDesignacao;

    @Enumerated(EnumType.STRING)
	private StatusPublicador status;

    @Embedded
    private Endereco endereco;

  //@OneToOne(mappedBy ="publicador", cascade = CascadeType.ALL,
   		//fetch = FetchType.LAZY, optional = true)
   //private List<Usuario> usuarios = new ArrayList<>();

	@OneToMany(mappedBy = "publicador", cascade = CascadeType.ALL)
	private List<Relatorio> relatorios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "congregacao_id", nullable = false)
    private Congregacao congregacao;
    
    /*
     * Metodo para adicionar um relatorio ao publicador
     */
public Relatorio adicionarRelatorio() {
		
		Relatorio relatorio = new Relatorio();
		
		relatorio.setMes(relatorio.getMes());
		relatorio.setDataRelatorio(OffsetDateTime.now());
		relatorio.setNumEstudosMes(relatorio.getNumEstudosMes());
		relatorio.setNumLiteraturaMes(relatorio.getNumLiteraturaMes());
		relatorio.setNumRevisitasMes(relatorio.getNumRevisitasMes());
		relatorio.setNumVideosMes(relatorio.getNumVideosMes());
		relatorio.setTotalHorasMes(relatorio.getTotalHorasMes());
		relatorio.setObservacoes(relatorio.getObservacoes());
		   
		relatorio.setPublicador(this);
		
		this.getRelatorios().add(relatorio);
		
		return relatorio;
		
	}
//
//public Usuario adicionarNome() {
//	
//	Usuario usuario = new Usuario();
//	
//	usuario.setNome(usuario.getNome());	   
//	usuario.setPublicador(this);
//	
//	this.getUsuarios().add(usuario);
//	
//	return usuario;
//	
//}

}
