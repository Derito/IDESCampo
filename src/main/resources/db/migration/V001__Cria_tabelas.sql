-- -----------------------------------------------------
-- Table `idescampo`.`pais`
-- -----------------------------------------------------
create table pais (
  id BIGINT NOT NULL auto_increment,
  nome_pais VARCHAR(60) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET= utf8mb4;
-- -----------------------------------------------------
-- Table `idescampo`.`cidade`
-- -----------------------------------------------------
create table cidade (
   id BIGINT NOT NULL auto_increment,
   nome_cid VARCHAR(60) NOT NULL,
   pais_id BIGINT NOT NULL,

  PRIMARY KEY (id)

  )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

  alter table cidade add constraint fk_pais_cidade
  foreign key (pais_id) references pais(id);

-- -----------------------------------------------------
-- Table `idescampo`.`congregacao`
-- -----------------------------------------------------
create table congregacao (
   id BIGINT NOT NULL auto_increment,
   activo BIT(1) NOT NULL,

   endereco_bairro VARCHAR(50) NOT NULL,
   endereco_municipio VARCHAR(50) NOT NULL,
   endereco_numero VARCHAR(15) NOT NULL,
   endereco_rua VARCHAR(30) NOT NULL,
   nome VARCHAR(60) NOT NULL,
   num_cong INT NOT NULL,
   endereco_cidade_id BIGINT NOT NULL,

  PRIMARY KEY (id)
  )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

  alter table congregacao add constraint fk_endereco_cidade
  foreign key (endereco_cidade_id) references cidade(id);
-- -----------------------------------------------------
-- Table `idescampo`.`grupo`
-- -----------------------------------------------------
create table grupo (
   id BIGINT NOT NULL auto_increment,
   nome VARCHAR(50) NOT NULL,

  PRIMARY KEY (id)
 )
 ENGINE = InnoDB
 DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `idescampo`.`permissao`
-- -----------------------------------------------------
create table permissao (
   id BIGINT NOT NULL auto_increment,
   descricao_per VARCHAR(100) NOT NULL,
   nome_per VARCHAR(25) NOT NULL,

  PRIMARY KEY (id)
 )
 ENGINE = InnoDB
 DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `idescampo`.`grupo_permissao`
-- -----------------------------------------------------
create table grupo_permissao (
   grupo_id BIGINT NOT NULL,
   permissao_id BIGINT NOT NULL

 )
 ENGINE = InnoDB
 DEFAULT CHARACTER SET = utf8mb4;

 alter table grupo_permissao add constraint fk_permissao_grupo_permissao
  foreign key (permissao_id) references permissao(id);

 alter table grupo_permissao add  constraint fk_grupo_grupo_permissao
  foreign key (grupo_id) references grupo(id);


-- -----------------------------------------------------
-- Table `idescampo`.`publicador`
-- -----------------------------------------------------
create table publicador (
   id bigint NOT NULL auto_increment,
   status VARCHAR(15) NOT NULL,
   data_designacao DATETIME NOT NULL,
   endereco_bairro VARCHAR(50) NOT NULL,
   endereco_municipio VARCHAR(50) NOT NULL,
   endereco_numero VARCHAR(15) NOT NULL,
   endereco_rua VARCHAR(30) NOT NULL,

   congregacao_id BIGINT NOT NULL,
   endereco_cidade_id BIGINT NOT NULL,

    PRIMARY KEY (id)
 )
 ENGINE = InnoDB
 DEFAULT CHARACTER SET = utf8mb4;
 

 alter table publicador add constraint fk_publicador_congregacao
  foreign key (congregacao_id) references congregacao(id);

 alter table publicador add constraint fk_publicador_endereco_cidade
  foreign key (endereco_cidade_id) references cidade(id);

-- -----------------------------------------------------
-- Table `idescampo`.`usuario`
-- -----------------------------------------------------
create table usuario (
   id BIGINT NOT NULL auto_increment,
   data_cadastro DATETIME NOT NULL,
   email VARCHAR(30) NOT NULL,
   nome VARCHAR(60) NOT NULL,
   senha VARCHAR(20) NOT NULL,   
   
   PRIMARY KEY (id)  
 )
 ENGINE = InnoDB
 DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `idescampo`.`relatorio`
-- -----------------------------------------------------
create table relatorio (
   id bigint NOT NULL auto_increment,
   data_relatorio DATETIME(6) NOT NULL,
   mes VARCHAR(25) NOT NULL,
   num_estudos_mes INT NOT NULL,
   num_literatura_mes INT NOT NULL,
   num_revisitas_mes INT NOT NULL,
   num_videos_mes INT NOT NULL,
   total_horas_mes INT NOT NULL,
   observacoes VARCHAR(255) NOT NULL,

   publicador_id bigint NOT NULL,

  PRIMARY KEY (id)
  )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

  alter table relatorio add constraint fk_relatorio_publicador
  foreign key (publicador_id) references publicador(id);

-- -----------------------------------------------------
-- Table `idescampo`.`usuario_grupo`
-- -----------------------------------------------------
create table usuario_grupo (
   usuario_id BIGINT NOT NULL,
   grupo_id BIGINT NOT NULL,

    FOREIGN KEY (usuario_id) REFERENCES usuario (id),
    FOREIGN KEY (grupo_id) REFERENCES grupo (id)
)
 ENGINE = InnoDB
 DEFAULT CHARACTER SET = utf8mb4;

 alter table usuario_grupo add constraint fk_usuario_grupo_usuario
  foreign key (usuario_id) references usuario(id);

 alter table usuario_grupo add constraint fk_usuario_grupo_grupo
  foreign key (grupo_id) references grupo(id);

  
