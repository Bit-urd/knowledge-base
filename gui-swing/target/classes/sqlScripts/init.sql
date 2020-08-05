IF EXISTS(SELECT *
          FROM sysdatabases
          WHERE name = 'disk_manage')
drop database  disk_manage
create database disk_manage COLLATE Chinese_PRC_CI_AS
GO

BEGIN transaction

  use disk_manage
  IF EXISTS(Select 1 From sys.sysobjects Where Name='te_user')
    Drop Table te_user
  IF EXISTS(Select 1 From sys.sysobjects Where Name='te_disk')
    Drop Table te_disk
  IF EXISTS(Select 1 From sys.sysobjects Where Name='tr_user_disk')
    Drop Table tr_user_disk
  IF EXISTS(Select 1 From sys.sysobjects Where Name='opera_log')
    Drop Table opera_log
  create table te_user(
                        id int primary key identity (1,1),
                        username nvarchar(10),
                        password nvarchar(10)
  )
  insert into te_user values ('张三','123456')
  insert into te_user values ('李四','123456')

  create table te_disk(
                        id int primary key identity (1,1),
                        name nvarchar(10)  ,
                        message nvarchar(10)  ,
                        num int
  )
  insert into te_disk values  ('Java','这个是Java',20)
  insert into te_disk values ('Python','这个是python',20)
  insert into te_disk values ('C++','这个是C++',20)
  create table tr_user_disk (
                              id int primary key identity (1,1),
                              username nvarchar(10),
                              diskname nvarchar(10)
  )
  create table opera_log (
                           diskid int FOREIGN key references te_disk(id),
                           content nvarchar(30),
                           operadate DATE
  )

commit transaction