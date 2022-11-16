insert into evento(id, nome, local_evento, data, horario) values
(1,'BDS-2022','Shopping Amazonas', '23/04/2022', '16:00'),
(2,'Fest Flight new','Shopping Amazonas', '20/04/2022', '18:00')
;

insert into convidado(id, nome, rg, idade, evento_id) values
(1, 'Amaral', '32202-12', 23, 1),
(2, 'Luciano', '02252-12', 26, 1),  
(3, 'Ammaral', '34426-06', 32, 2)  
;  

insert into usuario(id, username, password) values
(1, 'thiago', '$2a$10$3bBtLVKnR2IQoAYd/eJxz.J2VCtwIdlCAmFGnOQiK.GC9q7jyRvEa')  
; 