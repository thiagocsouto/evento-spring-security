create table evento(id integer auto_increment, nome varchar(50), local_evento varchar(50), data varchar(50), horario varchar(50));

create table convidado(id integer auto_increment, nome varchar(50), rg varchar(15), idade integer, evento_id integer); 

create table usuario(id integer auto_increment, username varchar(50), password varchar(80)); 

alter table convidado add constraint fk_evento foreign key(evento_id)
references evento(evento_id);