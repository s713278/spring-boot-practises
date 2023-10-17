create database nbcuni;
use nbcuni;
create table users
(
    username varchar(50) not null primary key,
    password varchar(500) not null,
    enabled boolean not null
);
    create table authorities
    (
        username varchar(50) not null,
        authority varchar(50) not null,
        constraint fk_authorities_users
            foreign key (username)
            references users (username)
    );
create unique index ix_auth_username
on authorities
(
    username,
    authority
);

insert into users(username,password,enabled) values ('admin','admin1234',1);
insert into users(username,password,enabled) values('read','admin1234',1);
insert into users(username,password,enabled) values('write','admin1234',1);
insert into authorities(username,authority) values('admin','admin');
insert into authorities(username,authority) values('read','read');
insert into authorities(username,authority) values('write','write');
commit;