if (exists (select * from sys.objects where name = 'proc_insertlog'))
  drop proc proc_insertlog
go
create proc proc_insertlog
(@diskid int, @content nvarchar(30),@operadate DATE)
  as
insert into opera_log values( @diskid, @content, @operadate);
go


