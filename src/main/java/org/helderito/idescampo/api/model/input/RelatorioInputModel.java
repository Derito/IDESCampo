package org.helderito.idescampo.api.model.input;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelatorioInputModel {

	    private String Mes;	   
	    private OffsetDateTime dataRelatorio;
	    private int Horas;
	    private int revisitas;
	    private int Estudos;
	    private int numLiteraturaMes;
	    private int Videos;
	    private String Observacoes;
	    private PublicadorInputModel publicadorInputModel;
	  
}
