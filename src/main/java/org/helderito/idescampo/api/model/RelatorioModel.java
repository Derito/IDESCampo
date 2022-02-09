package org.helderito.idescampo.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelatorioModel {

		
	    private String mes;	   
	    private OffsetDateTime data;
	    private int horas;
	    private int revisitas;
	    private int estudos;
	    private int literatura;
	    private int videos;
	    private String observacoes;
	    private PublicadorModel publicador;
	    
}
