DROP TABLE if exists users;
DROP TABLE if exists clients;
DROP TABLE if exists opinions;
DROP TABLE if exists land_lords;
DROP TABLE if exists apartment;
DROP TABLE if exists rents;
DROP TABLE if exists agreements;
DROP TABLE if exists payments;

CREATE table users
(
    id       int primary key auto_increment,
    name     varchar(100) not null,
    lastName varchar(100) not null,
    email    varchar(100) not null,
    phone    int          not null,
    login    varchar(100) not null
);

CREATE TABLE clients
(
    id              int primary key auto_increment,
    user_id         int not null,
    amount_of_rents int not null,
    occupation      varchar(100),
    foreign key (user_id) references users (id)
);

CREATE TABLE landlords
(
    id       int primary key auto_increment,
    id_card  int          not null,
    address  varchar(100) not null,
    street   varchar(100) not null,
    postcode varchar(100) not null,
    city     varchar(100) not null,
    country  varchar(100) not null,
    user_id  int          not null,
    foreign key (user_id) references users (id)
);

create table opinions
(
    id          int primary key auto_increment,
    text        varchar(100) not null,
    client_id   int          not null,
    landlord_id int          not null,
    foreign key (client_id) references clients (id),
    foreign key (landlord_id) references landlords (id)
);

CREATE TABLE apartments
(
    id              int primary key auto_increment,
    name            varchar(100) not null,
    address         varchar(100) not null,
    street          varchar(100) not null,
    postcode        int          not null,
    city            varchar(100) not null,
    country         varchar(100) not null,
    room_number     int          null,
    sleeping_places int          null,
    flat_area       int          null,
    is_empty        BIT          not null,
    date_from       DATE         not null,
    date_to         DATE         not null,
    price           double       not null,
    parking         BIT          not null,
    wi_fi           BIT          not null,
    photo           varchar(100) not null,
    landlord_id     int          not null,
    foreign key (landlord_id) references landlords (id)
);

create table rents
(
    id           int primary key auto_increment,
    date_from    date   not null,
    date_to      date   not null,
    monthly_fee  double not null,
    client_id    int    not null,
    apartment_id int    not null,
    foreign key (client_id) references clients (id),
    foreign key (apartment_id) references apartments (id)
);

create table agreements
(
    id          int primary key auto_increment,
    discount    double null,
    deposit     double null,
    client_id   int    not null,
    landlord_id int    not null,
    foreign key (client_id) references clients (id),
    foreign key (landlord_id) references landlords (id)
);

create table payments
(
    id      int primary key auto_increment,
    date    date   not null,
    fee     double not null,
    rent_id int    not null,
    foreign key (rent_id) references rents (id)
);





