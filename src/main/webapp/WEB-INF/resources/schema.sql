drop table if exists spittle;
drop table if exists spitter;

create table info (
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(25) not null,
  email varchar(25) not null
);