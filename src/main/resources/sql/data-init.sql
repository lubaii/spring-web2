DELETE from COURSE;
insert into COURSE(NAME, DURATION) VALUES ('Java-1',10);
insert into COURSE(NAME, DURATION) VALUES ('Java-2',20);
insert into COURSE(NAME, DURATION) VALUES ('Java-3',30);
insert into COURSE(NAME, DURATION) VALUEs ('Java-4',40);
insert into COURSE(NAME, DURATION) VALUES ('Java-5',50);
insert into COURSE(NAME, DURATION) VALUES ('Java-6',60);
insert into COURSE(NAME, DURATION) VALUES ('Java-7',70);

delete from TEACHER;
insert into TEACHER(FIO, ABOUT)  values ('Иванов-1','Java-1');
insert into TEACHER(FIO, ABOUT)  values ('Иванов-2','Java-2');
insert into TEACHER(FIO, ABOUT)  values ('Иванов-3','Java-3');
insert into TEACHER(FIO, ABOUT)  values ('Иванов-4','Java-4');
insert into TEACHER(FIO, ABOUT)  values ('Иванов-5','Java-5');
insert into TEACHER(FIO, ABOUT)  values ('Иванов-6','Java-6');
insert into TEACHER(FIO, ABOUT)  values ('Иванов-7','Java-7');
insert into TEACHER(FIO, ABOUT)  values ('Иванов-8','Java-8');
insert into TEACHER(FIO, ABOUT)  values ('Иванов-9','Java-9');

create table if not exists users(username varchar_ignorecase(50) not null primary key,
password varchar_ignorecase(500) not null,
enabled boolean not null);

create table if not exists authorities (
username varchar_ignorecase(50) not null, authority varchar_ignorecase(50) not null,
constraint fk_authorities_users foreign key(username) references users(username));

create unique index IF not exists ix_auth_username on authorities (username,authority);

DELETE FROM AUTHORITIES;
DELETE FROM USERS;
INSERT INTO USERS(USERNAME,PASSWORD,ENABLED)VALUES ('admin','$2a$10$V6hDRdZOYxLz/l8BtU4bTOKygYLWqVHdUfkLJeQSuo6dukp8PGWR6',true );
INSERT INTO AUTHORITIES(USERNAME,authority)values ('admin','ROLE_TEACHER');