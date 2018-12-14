drop table if exists spittle;
drop table if exists spitter;

create table spitter (
  id integer identity primary key,
  username varchar(25) not null,
  password varchar(25) not null,
  firstName varchar(100) not null,
  lastName varchar(100) not null,
  email varchar(50) not null
);

create table spittle (
  id integer identity primary key,
  spitterId integer not null,
  message varchar(2000) not null,
  postedTime datetime not null,
  foreign key (spitterId) references spitter(id)
);
