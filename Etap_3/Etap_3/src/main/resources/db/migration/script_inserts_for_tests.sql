/*USERS */
insert into users
values (0, 'test name 0', 'test last name 0', 'test email 0', 123456789, 'test login 0',
        'test password 0');
insert into users
values (1, 'test name 1', 'test last name 1', 'test email 1', 123456789, 'test login 1',
        'test password 1');
insert into users
values (2, 'test name 2', 'test last name 2', 'test email 2', 123456789, 'test login 2',
        'test password 2');
insert into users
values (3, 'test name 3', 'test last name 3', 'test email 3', 123456789, 'test login 3',
        'test password 3');

/*CLIENTS */
insert into clients
values (0,'Tomasz','Nowak','tomaszn@test.pl',24, 1, 'test occupation 0', 0);
insert into clients
values (1,'Sylwia','Tentrak','sylwiat@test.pl',34, 5, 'test occupation 1', 1);

/*ADDRESSES */
insert into addresses
values (0, 0, 0, 'test street 0', 'test postcode 0', 'test city 0', 'test country 0');
insert into addresses
values (1, 1, 1, 'test street 1', 'test postcode 1', 'test city 1', 'test country 1');
insert into addresses
values (2, 2, 2, 'test street 2', 'test postcode 2', 'test city 2', 'test country 2');

/*LANDLORDS */
insert into landlords
values (0, 0, 0, 0);
insert into landlords
values (1, 1, 1, 1);
insert into landlords
values (2, 2, 2, 2);

/*ADDITIONAL_FIELDS */
insert into additional_fields
values (0, 0, 0, 0, 0);
insert into additional_fields
values (1, 1, 0, 1, 0);
insert into additional_fields
values (2, 1, 1, 1, 1);

/*APARTMENTS */
insert into APARTMENTS
values (0, 'test name 0', 0, 2, 20, 1, DATE '2021-01-22', DATE '2021-05-11', 200, 1, 1, 'test photo 0', 0, 0, 0);
insert into APARTMENTS
values (1, 'test name 1', 1, 2, 30, 1, DATE '2021-03-11', DATE '2021-08-11', 150, 0, 1, 'test photo 0', 1, 1, 1);

/*OPINIONS */
insert into opinions
values (0, 'test text 0', 0, 0, 0, 0);
insert into opinions
values (1, 'test text 1', 1, 1, 0, 1);




