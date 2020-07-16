create sequence hibernate_sequence start with 100 increment by 1;

create table report
(id bigint not null,
content varchar(255) not null,
theme varchar(255) not null,
time timestamp not null,
owner_id integer,
constraint PK_REPORT_ID primary key (id));

create table speaker (
id integer not null,
name varchar(255) not null,
patronim varchar(255) not null,
surname varchar(255) not null,
constraint PR_SPEAKER_ID primary key (id));

alter table speaker add constraint UK_SPEAKER_FIO unique (name, patronim, surname);

alter table report add constraint FK_REPORT_OWNER_ID foreign key (owner_id) references speaker on delete cascade;
