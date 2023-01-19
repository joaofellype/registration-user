CREATE TABLE pessoa(
pes_id int not null primary key auto_increment,
pes_nome varchar(200),
pes_data_nascimento date,
pes_sexo varchar(9),
pes_mae varchar(200),
pes_pai varchar(200)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE pessoa_foto(
fp_id int not null primary key auto_increment,
fp_data date,
fb_bucket varchar(50),
fp_hash varchar(50),
pes_id int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE servidor_temporario(
pes_id int,
st_data_admissao date,
st_data_demissao date
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE servidor_efetivo(
pes_id int,
se_matricula varchar(20)

);
ALTER TABLE pessoa_foto
ADD FOREIGN KEY (pes_id) REFERENCES pessoa(pes_id);

ALTER TABLE servidor_temporario
ADD FOREIGN KEY (pes_id) REFERENCES pessoa(pes_id);

ALTER TABLE servidor_efetivo
ADD FOREIGN KEY (pes_id) REFERENCES pessoa(pes_id);