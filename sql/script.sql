insert into USUARIO values(null,null,curdate(),1,'dannhideki','c62d929e7b7e7b6165923a5dfc60cb56','');
insert into PESSOA values(null,'12-9102-5204',null,curdate(),'1977-07-02','dann.hideki@gmail.com','Daniel Hideki','Cassi',null,1460281313033,'MASCULINO',null,1);
insert into USUARIO_PERMISSAO values(1,'ROLE_ADMIN');

insert into CATEGORIA_PESSOA values(null,1,null,curdate(),'Aluno',null,1);
insert into CATEGORIA_PESSOA values(null,1,null,curdate(),'Professor',null,1);
insert into CATEGORIA_PESSOA values(null,1,null,curdate(),'Funcionário',null,1);
insert into CATEGORIA_PESSOA values(null,1,null,curdate(),'Visitante',null,1);
insert into CATEGORIA_PESSOA values(null,1,null,curdate(),'Estagiário',null,1);

UPDATE PESSOA SET categoria_pessoa_id = 1 where id = 1;

insert into PESSOA values(null,null,null,curdate(),null,null,'ALEXANDRE DE SOUZA','COTTA',null,1460271012002,'MASCULINO',1,NULL);
insert into PESSOA values(null,null,null,curdate(),null,null,'ANA ERCILIA FERNANDES','CAMILO',null,1460271012004,'FEMININO',1,NULL);
insert into PESSOA values(null,null,null,curdate(),null,null,'ANDERSON CAMPOS','COSTA',null,1460271012005,'MASCULINO',1,NULL);
insert into PESSOA values(null,null,null,curdate(),null,null,'ANGELA SAEMI KUMAMOTO','TAKESAKI',null,1460271012007,'MASCULINO',1,NULL);
insert into PESSOA values(null,null,null,curdate(),null,null,'ANTONIO MIGUEL MATIOLI','JUNIOR',null,1460271012008,'MASCULINO',1,NULL);
insert into PESSOA values(null,null,null,curdate(),null,null,'ARIOVALDO DE SOUZA','JUNIOR',null,1460271012009,'MASCULINO',1,NULL);
insert into PESSOA values(null,null,null,curdate(),null,null,'CARLOS EGIDIO DOS SANTOS','JUNIOR',null,1460271012010,'MASCULINO',1,NULL);
insert into PESSOA values(null,null,null,curdate(),null,null,'CESAR CALLEO DE SOUZA','SANTOS',null,1460271012011,'MASCULINO',1,NULL);
insert into PESSOA values(null,null,null,curdate(),null,null,'CRISTIANO FERREIRA DE','OLIVEIRA',null,1460271012012,'MASCULINO',1,NULL);
insert into PESSOA values(null,null,null,curdate(),null,null,'DENISE ALVES DE','BARROS',null,1460271012013,'MASCULINO',1,NULL);
insert into PESSOA values(null,null,null,curdate(),null,null,'FELIPE AUGUSTO ','NOGUEIRA',null,1460271012015,'MASCULINO',1,NULL);
