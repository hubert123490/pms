create table roles
(
    id   int primary key auto_increment,
    name varchar(20)
);

create table user_roles
(
    id      int primary key auto_increment,
    user_id int not null,
    role_id int not null
);
