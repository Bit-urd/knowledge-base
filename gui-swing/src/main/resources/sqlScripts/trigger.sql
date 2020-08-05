if (object_id('tri_borrow_revert', 'tr') is not null)
  drop trigger tri_borrow_revert
go

CREATE TRIGGER tri_borrow_revert  ON te_disk
FOR  update as
  declare @diskid int,@content nvarchar(30),@operadate date
  select @diskid=id,@content=message from inserted;
  SELECT  @operadate=SYSDATETIME()
exec proc_insertlog @diskid,@content,@operadate;
