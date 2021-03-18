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
    id int primary key auto_increment
);

CREATE TABLE apartments
(
    id int primary key auto_increment
);

CREATE table users
(
    id           int primary key auto_increment,
    email        varchar(100) not null,
    login        varchar(100) not null,
    tenant_id    int          null,
    landlord_id int          null,
    foreign key (tenant_id) references tenants (id),
    foreign key (landlord_id) references landlords (id)
);
