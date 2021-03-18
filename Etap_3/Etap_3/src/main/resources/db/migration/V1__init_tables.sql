DROP TABLE if exists tenants;
DROP TABLE if exists land_lords;
DROP TABLE if exists apartments;
DROP TABLE if exists users;

CREATE table users
(
    id           int primary key auto_increment,
    email        varchar(100) not null,
    login        varchar(100) not null,
    tenant_id    int          null,
    land_lord_id int          null,
    foreign key (tenant_id) references tenants (id),
    foreign key (land_lord_id) references land_lords (id)
);

CREATE TABLE tenants
(
    id int primary key auto_increment,
);

CREATE TABLE land_lords
(
    id int primary key auto_increment,
);

CREATE TABLE apartments
(
    id int primary key auto_increment,
);
