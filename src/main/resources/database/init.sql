create
database schoolManagement;
use
schoolManagement;

drop
database if exists teachers;
create table teachers
(
    id      int primary key auto_increment,
    name    varchar(255) not null,
    address varchar(255),
    subject varchar(255) not null
);

insert into teachers (name, address, subject)
values ('Mạnh', 'Tây Ninh', 'TOAN'),
       ('Nam', 'Ba Vi', 'LY'),
       ('Thao', 'Quảng Ninh', 'SINH'),
       ('Thanh', 'Nam Định', 'HOA');



drop
database if exists students;
create table students
(
    id         int primary key auto_increment,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    age        int,
    address    varchar(255),
    gender     varchar(255),
    teacher_id int          NOT NULL,
    FOREIGN KEY (teacher_id) references teachers (id)
);

