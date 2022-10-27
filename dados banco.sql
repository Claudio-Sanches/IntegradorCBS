-- inserção de dados 

drop database databaseepi;

create database databaseepi;

use databaseepi;

insert into cliente values(1, 'Vila Leopoldina', 11924245656, '05305030', 'São Paulo' , 'ap. 32', '05578932441', 'msilva@gmail.com', 'Manoel Silva', 142, 'Paulo Franco', 1132235445, 'SP', Null);
insert into cliente values(2, 'Vila Anastacio', 11978744554, '05307320', 'São Paulo' , 'ap. 54', '05454332561', 'psantos@gmail.com', 'Pedro Santos', 732, 'Shilling', 1145541221, 'SP', Null);
insert into cliente values(3, 'Vila Leopoldina', 11997564112, '05307320', 'São Paulo' , 'ap. 122', '0374589654', 'lgsilva@gmail.com', 'Larissa Grabriela Silva', 22, 'Carlos Weber', 1134235647, 'SP', Null);
insert into cliente values(4, 'Vila Leopoldina', 11997564112, '05307320', 'São Paulo' , 'ap. 44', '12378468512', 'mcmoraes@gmail.com', 'Marina Catarina Moraes', 934, 'Carlos Weber', 1134235647, 'SP', Null);

insert into produto values(1,"Pessoal","NOVO INSPIRION 15 3000 - PRONTO PARA O USO - Notebook 15 polegadas em um design elegante com bordas finas - Bateria ExpressCharge - Teclado numerico - Processador Intel Core I7",5000.00,NULL);
insert into produto values(2,"Pessoal","ALL IN ONE INSPIRION 24 5000 - PRONTO PARA O USO - Monitor 20 polegadas em um design moderno - Bateria ExpressCharge - Teclado numerico + Mouse - Processador Intel Core I5",7000.00,NULL);
insert into produto values(3,'Profissional','NOVO INSPIRION 15 3100 - PRONTO PARA O USO - Notebook 15 polegadas em um design elegante com bordas finas - Bateria ExpressCharge - Teclado numérico - Processador Pentium Gold dual Core - Placa de Vídeo Integrada', 3500.00, NULL);
insert into produto values(4,'Profissional','ALL IN ONE INSPIRION 24 6000 - PRONTO PARA O USO - Monitor 20 polegadas em um design moderno - Bateria ExpressCharge - Teclado numérico + Mouse - Processador Intel Core I7 - Placa de Vídeo Integrada', 7500.00, NULL);
insert into produto values(5,'Gamer','Notebook Gamer Dell G3 15 - PRONTO PARA O USO - Notebook 15 polegadas em um design elegante - Bateria ExpressCharge - Processador Intel I7 10 geracao - Placa grafica NVIDA GeForce', 6500.00, NULL);
insert into produto values(6,'Gamer','Monitor Gamer Curvo - 23.6 polegadas Dell S2422HG - Seu proximo nivel esta aqui - Monitor Gamer Full HD de 23.6 polegadas taxa de atualizacao 144hz e tempo de resposta de 1ms, agil e com grande capacidade de resposta', 2850.00, NULL);
insert into produto values(7,'Acessórios','Volante Logitec Driving Force G29 - Para Play Station 4, 3 e PC - Otimize sua experiencia em console - Voce nunca mais vai querer correr com outro controle - Projetado para jogos de corrida', 1850.00, NULL);

insert into ssd values(1, '128 GigaBites', 250, null);
insert into ssd values(2, '256 GigaBites', 500, null);
insert into ssd values(3, '512 GigaBites', 750, null);
insert into ssd values(4, '1 TeraBite', 950, null);

insert into memoria values(1, '4 GigaBites', 250, null);
insert into memoria values(2, '8 GigaBites', 500, null);
insert into memoria values(3, '16 GigaBites', 750, null);
insert into memoria values(4, '32 GigaBites', 950, null);

insert into karrinho values(1, 'Manoel Silva',  '4 GigaBites', "NOVO INSPIRION 15 3000 - PRONTO PARA O USO - Notebook 15 polegadas em um design elegante com bordas finas - Bateria ExpressCharge - Teclado numerico - Processador Intel Core I7",1,'128 GigaBites',"Pessoal",0, Null);
insert into karrinho values(2, 'Pedro Santos', '8 GigaBites', "ALL IN ONE INSPIRION 24 5000 - PRONTO PARA O USO - Monitor 20 polegadas em um design moderno - Bateria ExpressCharge - Teclado numerico + Mouse - Processador Intel Core I5", 1,'256 GigaBites',"Pessoal",0,Null);
insert into karrinho values(3, 'Larissa Grabriela Silva', '16 GigaBites', 'NOVO INSPIRION 15 3100 - PRONTO PARA O USO - Notebook 15 polegadas em um design elegante com bordas finas - Bateria ExpressCharge - Teclado numérico - Processador Pentium Gold dual Core - Placa de Vídeo Integrada', 1,'512 GigaBites','Profissional',0,Null);
insert into karrinho values(4, 'Marina Catarina Moraes','32 GigaBites', 'Notebook Gamer Dell G3 15 - PRONTO PARA O USO - Notebook 15 polegadas em um design elegante - Bateria ExpressCharge - Processador Intel I7 10 geracao - Placa grafica NVIDA GeForce', 1, '1 TeraBite','Gamer',0,Null);

insert into opedido values(1, 'Manoel Silva',  '4 GigaBites', "NOVO INSPIRION 15 3000 - PRONTO PARA O USO - Notebook 15 polegadas em um design elegante com bordas finas - Bateria ExpressCharge - Teclado numerico - Processador Intel Core I7",1,'128 GigaBites',"Pessoal",0, Null);
insert into opedido values(2, 'Pedro Santos', '8 GigaBites', "ALL IN ONE INSPIRION 24 5000 - PRONTO PARA O USO - Monitor 20 polegadas em um design moderno - Bateria ExpressCharge - Teclado numerico + Mouse - Processador Intel Core I5", 1,'256 GigaBites',"Pessoal",0,Null);
insert into opedido values(3, 'Larissa Grabriela Silva', '16 GigaBites', 'NOVO INSPIRION 15 3100 - PRONTO PARA O USO - Notebook 15 polegadas em um design elegante com bordas finas - Bateria ExpressCharge - Teclado numérico - Processador Pentium Gold dual Core - Placa de Vídeo Integrada', 1,'512 GigaBites','Profissional',0,Null);
insert into opedido values(4, 'Marina Catarina Moraes','32 GigaBites', 'Notebook Gamer Dell G3 15 - PRONTO PARA O USO - Notebook 15 polegadas em um design elegante - Bateria ExpressCharge - Processador Intel I7 10 geracao - Placa grafica NVIDA GeForce', 1, '1 TeraBite','Gamer',0,Null);


-- tabela de estados

insert into estado values(1, 1 , 'São Paulo', 'SP');
insert into estado values(2, 1.01, 'Rio de Janeiro', 'RJ' );
insert into estado values(3, 1.02, 'Minas Gerais' , 'MG');
insert into estado values(4, 1.03, 'Rio Grande do Sul' , 'RS');
insert into estado values(5, 1.04, 'Santa Catarina' , 'SC');
insert into estado values(6, 1.05, 'Paraná' , 'PR');
insert into estado values(7, 1.06, 'Espirito Santo' , 'ES');
insert into estado values(8, 1.07, 'Bahia' , 'BA');
insert into estado values(9, 1.08, 'Sergipe' , 'SE');
insert into estado values(10, 1.09, 'Alagoas' , 'AL');
insert into estado values(11, 1.10, 'Pernabuco' , 'PE');
insert into estado values(12, 0.99, 'Paraíba' , 'PB');
insert into estado values(13, 0.97, 'Ceará' , 'CE');
insert into estado values(14, 0.96, 'Piaui' , 'PI');
insert into estado values(15, 0.95, 'Maranhão' , 'MA');
insert into estado values(16, 0.94, 'Pará' , 'PA');
insert into estado values(17, 0.92, 'Roraima' , 'RR');
insert into estado values(18, 0.91, 'Amazonas' , 'AM');
insert into estado values(19, 0.9, 'Acre' , 'AC');
insert into estado values(20, 0.89, 'Romdônia' , 'RO');
insert into estado values(21, 0.88, 'Mato Grosso' , 'MT');
insert into estado values(22, 1.11, 'Mato Grosso do Sul' , 'MS');
insert into estado values(23, 1.12, 'Goias' , 'GO' );
insert into estado values(24, 1.13, 'Tocantins' ,'TO');
insert into estado values(25, 1.14, 'Distrito Federal' ,'DF');
insert into estado values(26, 1.15, 'Amapá' , 'AP');
insert into estado values(27, 1.16, 'Rio Grande do Norte' , 'RN');


delimiter //

create procedure databaseepi.gerar_tabela()
wholeblock:begin
declare x int default 0;
set x=1;

while x <=27 do

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto;

update tabela
set
uf = (select sigla from estado where id=x),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=1) * (select fator from estado where id=x),
valormemoria = (select valor from memoria where id=1) * (select fator from estado where id=x),
descricaossd = (select descricao from ssd where id=1),
descricaomemoria = (select descricao from memoria where id=1)

where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=1),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=1) * (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=2),
valormemoria = (select valor from memoria where id=2) * (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=1),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=1) * (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=3),
valormemoria = (select valor from memoria where id=3) * (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=1),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=1)* (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=4),
valormemoria = (select valor from memoria where id=4) * (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=2),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=2)* (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=1),
valormemoria = (select valor from memoria where id=1) * (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;

update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=2),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=2) * (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=2),
valormemoria = (select valor from memoria where id=2)  * (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=2),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=2) * (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=3),
valormemoria = (select valor from memoria where id=3) * (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=2),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=2) * (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=4),
valormemoria = (select valor from memoria where id=4) * (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=3),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=3) * (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=1),
valormemoria = (select valor from memoria where id=1) * (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;

update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=3),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=3)* (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=2),
valormemoria = (select valor from memoria where id=2)* (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=3),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=3)* (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=3),
valormemoria = (select valor from memoria where id=3)* (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=3),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=3)* (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=4),
valormemoria = (select valor from memoria where id=4)* (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=4),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=4)* (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=1),
valormemoria = (select valor from memoria where id=1)* (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;

update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=4),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=4)* (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=2),
valormemoria = (select valor from memoria where id=2)* (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor
        from produto
         where aplicacao in ('pessoal', 'Profissional') ;
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=4),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=4)* (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=3),
valormemoria = (select valor from memoria where id=3)* (select fator from estado where id=x)
where uf is null ;

insert into tabela (aplicacao, descricao,valor)
        select aplicacao, descricao, valor 
        from produto
        where aplicacao in ('pessoal', 'Profissional');
        
update tabela
set
uf = (select sigla from estado where id=x),
descricaossd = (select descricao from ssd where id=4),
valor = valor * (select fator from estado where id=x),
valorssd = (select valor from ssd where id=4) * (select fator from estado where id=x),
descricaomemoria = (select descricao from memoria where id=4),
valormemoria = (select valor from memoria where id=4) * (select fator from estado where id=x)
where uf is null ;

update tabela
set
descricaossd = ' ',
valorssd = 0,
descricaomemoria = ' ',
valormemoria = 0
where aplicacao = 'Gamer' ;

update tabela
set
descricaossd = ' ',
valorssd = 0,
descricaomemoria = ' ',
valormemoria = 0
where aplicacao = 'Acessórios';
set x=x +1;
end while;
end//
 
call gerar_tabela();

