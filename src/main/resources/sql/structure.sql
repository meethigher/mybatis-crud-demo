create table Major (majorId varchar(255) not null, schoolId varchar(255) not null, createTime datetime, majorName varchar(255), primary key (majorId, schoolId));
create table School (schoolId varchar(255) not null, createTime datetime, schoolName varchar(255), schoolState integer, primary key (schoolId));
