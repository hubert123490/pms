/*DROP TABLE if exists apartments;
DROP TABLE if exists tenants;
DROP TABLE if exists land_lords;
DROP TABLE if exists users;*/

CREATE TABLE tenants
(
    id int primary key auto_increment
);

CREATE TABLE landlords
(
    id int primary key auto_increment,
    id_card int not null,
    address varchar(100) not null,
    street  varchar(100) not null,
    postcode    varchar(100) not null,
    city    varchar(100) not null,
    country varchar(100) not null
);

create table opinions
(
    id int primary key auto_increment,
    text varchar(100) not null ,
    tenant_id int not null ,
    landlord_id int not null,
    foreign key (tenant_id) references tenants (id),
    foreign key (landlord_id) references landlords (id)
);

CREATE TABLE apartments
(
    id int primary key auto_increment,
    name    varchar(100) not null,
    address varchar(100) not null,
    street  varchar(100) not null,
    postcode    int not null,
    city    varchar(100) not null,
    country varchar(100) not null,
    room_number int null,
    sleeping_places int null,
    flat_area int null,
    is_empty BIT not null,
    date_from DATE not null,
    date_to DATE not null,
    price double not null,
    parking BIT not null,
    wi_fi BIT not null,
    photo varchar(100) not null
);

create table rents
(
    id int primary key auto_increment,
    date_from date not null ,
    date_to date not null,
    tenant_id int not null ,
    apartment_id int not null ,
    foreign key (tenant_id) references tenants (id),
    foreign key (apartment_id) references apartments (id)
);

CREATE table users
(
    id  int primary key auto_increment,
    name    varchar(100) not null,
    lastName    varchar(100) not null,
    email   varchar(100) not null,
    phone   int not null,
    login   varchar(100) not null,
    tenant_id   int,
    landlord_id int,
    foreign key (tenant_id) references tenants (id),
    foreign key (landlord_id) references landlords (id)
);

CREATE table rental_history
(
    id  int primary key auto_increment,
    rents_id int,
    foreign key (rents_id) references rents (id)
);
