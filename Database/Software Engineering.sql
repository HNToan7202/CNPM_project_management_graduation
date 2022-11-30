create database QuanLyDetai
go
use QuanLyDetai
go
CREATE TABLE [role] (
  [id] int PRIMARY KEY identity,
  [name] nvarchar(255)
)
GO

CREATE TABLE [account] (
  [email] nvarchar(255) PRIMARY KEY,
  [role_id] int FOREIGN KEY REFERENCES [role]([id]),
  [password] nvarchar(255),
  is_active bit
)
GO

CREATE TABLE [admin] (
  [id] int PRIMARY KEY identity,
  [name] nvarchar(100),
  [email] nvarchar(255) FOREIGN KEY REFERENCES [account]([email]),
  is_active bit 
)
GO

CREATE TABLE [timeresgiter] (
  [id] int PRIMARY KEY identity,
  [create_at] date,
  [finish_at] date,
)
GO
create TABLE [project] (
  [id] int PRIMARY KEY identity,
  [name] nvarchar(255),
  [desciption] nvarchar(255),
  [muctieu] nvarchar(255),
  [yeucau] nvarchar(255),
  [soluongsv] int default 0,
  [isfaculty] bit,
  [faculty] nvarchar(255),
  [nienkhoa] nvarchar(255),
  [point] float default 0,
  [idtimeproject] int FOREIGN KEY REFERENCES [timeresgiter]([id]),
  [create_at] date default GetDate(),
  [update_at] date,
  [is_active] bit
)
GO

CREATE TABLE [student] (
  [mssv] int PRIMARY KEY,
  [name] nvarchar(255),
  [dateofbirth] date,
  [image] varchar(255),
  [email] nvarchar(255) FOREIGN KEY REFERENCES [account]([email]),
  [faculty] nvarchar(255),
  [is_leader] bit,
  [id_project] int FOREIGN KEY REFERENCES [project]([id]),
  is_active bit
)
GO

CREATE TABLE [leaderlecture] (
  [id] int PRIMARY KEY identity,
  [name] nvarchar(100),
  [dateofbirth] date,
  [image] varchar(255),
  [email] nvarchar(255) FOREIGN KEY REFERENCES [account]([email]),
  address nvarchar(500),
  is_active bit
)
GO
CREATE TABLE [hoidong] (
  [id] int PRIMARY KEY identity,
  [soluongtv] int default 0,
  [id_project] int FOREIGN KEY REFERENCES [project]([id]),
  [id_headLecture] int FOREIGN KEY REFERENCES [leaderlecture]([id]),
  is_active bit
)
GO

CREATE TABLE [lecture] (
  [id] int PRIMARY KEY identity,
  [name] nvarchar(255),
  [dateofbirth] date,
  address varchar(500),
  [image] varchar(255),
  [email] nvarchar(255) FOREIGN KEY REFERENCES [account]([email]),
  [id_project] int FOREIGN KEY REFERENCES [project]([id]),
  [id_hoidong] int FOREIGN KEY REFERENCES [hoiDong]([id]),
  is_active bit
)
GO

CREATE TABLE [notification] (
  [id] int PRIMARY KEY identity,
  name nvarchar(50),
  [create_at] date,	
  [update_at] date,
  [desciption] nvarchar(255),
  [for_student] bit,
  [is_active] bit
)