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
values (8, 'test name 3', 'test last name 3', 'test email 3', 123456789, 'test login 3',
        'test password 3');

/*CLIENTS */
insert into clients
values (0, 24, 1, 'test occupation 0', 2);
insert into clients
values (1, 34, 5, 'test occupation 1', 1);


/*ADDRESSES */
insert into addresses
values (0, 22, 1, 'plac zamkowy', '25-001', 'Kielce', 'Polska');
insert into addresses
values (1, 1, 1, 'test street 1', 'test postcode 1', 'test city 1', 'test country 1');
insert into addresses
values (2, 2, 2, 'test street 2', 'test postcode 2', 'test city 2', 'test country 2');
insert into addresses
values (4, 1, 6, 'Mordechaja Anielewicza', ' 00-157', 'Warszawa', 'Polska');


/*LANDLORDS */
insert into landlords
values (0, 0, 0);
insert into landlords
values (1, 1, 1);
insert into landlords
values (2, 2, 2);

/*ADDITIONAL_FIELDS */
insert into additional_fields
values (0, 0, 0, 0, 0,0,1);
insert into additional_fields
values (1, 1, 0, 1, 0,0,0);
insert into additional_fields
values (2, 1, 1, 1, 1,1,0);

/*APARTMENTS */
insert into APARTMENTS
values (0, 'test name 0', true, 4, 7, 70, true, DATE '2021-01-22', DATE '2021-05-11', 200, true, 'test photo 0', 3, 5, 'nowa','55-555','Kielce',
        'Polska',true,true,true,true,true,true,1);
-- insert into APARTMENTS
-- values (1, 'test name 1', 1, 2, 30, 1, DATE '2021-03-11', DATE '2021-08-11', 150, 0, 1, 'test photo 0', 1, 1, 1);

/*OPINIONS */
insert into opinions
values (0, 'test text 0',DATE '2021-01-23', 0, 0, 0, 0);
insert into opinions
values (1, 'test text 1',DATE '2021-02-02', 1, 1, 0, 1);

/*AGREEMENTS*/


insert into AGREEMENTS
values ( 0, 0, 0, DATE '2021-02-02',DATE '2021-03-08', 300, 0, 0, 0);

/*TOURIST_ATTRACTION*/

insert into TOURIST_ATTRACTION
values ( 0, 'Muzeum Narodowe w Kielcach','Muzeum Narodowe w Kielcach – placówka muzealna z ponad 100-letnią tradycją. W swoich zbiorach posiada cenne eksponaty z dziedziny malarstwa, rzemiosła artystycznego, sztuki ludowej, archeologii i przyrody.','https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d10071.808640943464!2d20.6274231!3d50.8690854!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xdad7485d26e29c9e!2sMuzeum%20Narodowe%20w%20Kielcach!5e0!3m2!1spl!2spl!4v1623612433841!5m2!1spl!2spl','https://kielce.travel/media/cache/original/uploads/5f7ed2cc3da11.jpg','https://kielce.travel/media/cache/original/uploads/5f7ed2cc3da11.jpg',1 );

insert into TOURIST_ATTRACTION
values ( 1, 'POLIN Muzeum Historii Żydów Polskich','Muzeum Historii Żydów Polskich Polin – muzeum znajdujące się w Śródmieściu Warszawy, na Muranowie, dokumentujące wielowiekową historię Żydów w Polsce.','https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d9770.712485704196!2d20.9936657!3d52.2492299!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xe21ada43504430b0!2sPOLIN%20Muzeum%20Historii%20%C5%BByd%C3%B3w%20Polskich!5e0!3m2!1spl!2spl!4v1623617172896!5m2!1spl!2spl','https://ocdn.eu/images/pulscms/NGM7MDA_/84fd31c971261e724ae61f29be81541e.jpeg','https://polin.pl/sites/default/files/pictures/20130824_budynek_fot_maciej_jezyk_004.jpg',4 );




