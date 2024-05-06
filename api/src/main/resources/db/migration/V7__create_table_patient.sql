create table patient(

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    zip_code varchar(9) not null,
    complement varchar(100),
    numero varchar(20),
    state char(2) not null,
    city varchar(100) not null,
    active tinyint,
    primary key(id),

);