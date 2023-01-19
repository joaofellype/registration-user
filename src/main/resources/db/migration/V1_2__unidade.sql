CREATE TABLE unidade(
unid_id int not null primary key auto_increment,
unid_nome varchar(200),
unid_sigla varchar(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE lotacao(
lot_id int primary key not null auto_increment,
pes_id int,
unid_id int,
lot_data_lotacao date,
lot_data_remocao date,
lot_portaria varchar(200)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE unidade_endereco(
unid_id int,
end_id int
);


ALTER TABLE lotacao
ADD FOREIGN KEY(unid_id) REFERENCES unidade(unid_id);


ALTER TABLE lotacao
ADD FOREIGN KEY(pes_id) REFERENCES unidade(unid_id);



ALTER TABLE unidade_endereco
ADD FOREIGN KEY(unid_id) REFERENCES unidade(unid_id);

ALTER TABLE unidade_endereco
ADD FOREIGN KEY(end_id) REFERENCES endereco(end_id);

