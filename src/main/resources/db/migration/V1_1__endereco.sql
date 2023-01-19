CREATE TABLE cidade(
cid_id int not null primary key auto_increment,
cid_nome varchar(200),
cid_uf char(2)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE endereco(
end_id int not null primary key auto_increment,
end_tipo_logradouro varchar(50),
end_logradouro varchar(200),
end_numero int,
end_bairro varchar(100),
cid_id int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE pessoa_endereco(
pes_id int,
end_id int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE endereco
ADD FOREIGN KEY(cid_id) REFERENCES cidade(cid_id);

ALTER TABLE pessoa_endereco
ADD FOREIGN KEY(end_id) REFERENCES endereco(end_id);

ALTER TABLE pessoa_endereco
ADD FOREIGN KEY(pes_id) REFERENCES pessoa(pes_id);

