DROP TABLE if exists users;
DROP TABLE if exists clients;
DROP TABLE if exists addresses;
DROP TABLE if exists landlords;
DROP TABLE if exists additional_fields;
DROP TABLE if exists apartment;
DROP TABLE if exists opinions;
DROP TABLE if exists agreements;
DROP TABLE if exists payments;

CREATE table users
(
    id        int primary key auto_increment,
    name      varchar(100),
    last_name varchar(100),
    email     varchar(100) not null,
    phone     int,
    login     varchar(100) not null,
    password  varchar(100) not null
);

CREATE TABLE clients
(
    id              int primary key auto_increment,
    age             int,
    amount_of_rents int not null,
    occupation      varchar(100),
    user_id         int not null,
    foreign key (user_id) references users (id)
);

create table addresses
(
    id                 int primary key auto_increment,
    apartment_number   int,
    apartment_building int          not null,
    street             varchar(100) not null,
    postcode           varchar(100) not null,
    city               varchar(100) not null,
    country            varchar(100) not null
);

CREATE TABLE landlords
(
    id         int primary key auto_increment,
    id_card    int not null,
    user_id    int not null,
    foreign key (user_id) references users (id)
);
create table additional_fields
(
    id                 int primary key auto_increment,
    no_smoking      BIT not null,
    no_animals      BIT not null,
    no_parties      BIT not null,
    parking_available  BIT not null,
    balcony_available  BIT not null,
    shops_nearby BIT not null
);

CREATE TABLE apartments
(
    id                  int primary key auto_increment,
    name                varchar(100) not null,
    room_number         int          null,
    sleeping_places     int          null,
    flat_area           int          null,
    is_empty            BIT          not null,
    date_from           DATE         not null,
    date_to             DATE         not null,
    price               double       not null,
    parking             BIT          not null,
    wi_fi               BIT          not null,
    photo               varchar(100) not null,
    landlord_id         int          not null,
    address_id          INT          not null,
    additional_field_id int          not null,
    foreign key (landlord_id) references landlords (id),
    foreign key (address_id) references addresses (id),
    foreign key (additional_field_id) references additional_fields (id)
);

create table opinions
(
    id             int primary key auto_increment,
    text           varchar(100) not null,
    published_date DATE         not null,
    client_id      int,
    landlord_id    int,
    apartment_id   int,
    user_id        int,
    foreign key (apartment_id) references apartments (id),
    foreign key (client_id) references clients (id),
    foreign key (landlord_id) references landlords (id),
    foreign key (user_id) references users (id)
);

create table agreements
(
    id           int primary key auto_increment,
    discount     double null,
    deposit      double null,
    date_from    date   not null,
    date_to      date   not null,
    daily_fee  double not null,
    client_id    int    not null,
    apartment_id int    not null,
    landlord_id  int    not null,
    foreign key (client_id) references clients (id),
    foreign key (landlord_id) references landlords (id),
    foreign key (apartment_id) references apartments (id)
);

create table payments
(
    id           int primary key auto_increment,
    date         date   not null,
    fee          double not null,
    payment_done bit not null ,
    agreement_id int    not null,
    foreign key (agreement_id) references agreements (id)
);

create table tourist_attraction
(
    id int primary key auto_increment,
    city varchar(100) not null,
    description varchar(250) not null
);








