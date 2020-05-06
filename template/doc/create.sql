/*==============================================================*/
/* Table: 用户表                                                  */
/*==============================================================*/
create table USER
(
   ID                   varchar(32) not null,
   NAME                 varchar(50),
   STATUS               smallint(1),
   CREATE_BY            varchar(50),
   CREATE_TIME          datetime,
   UPDATE_BY            varchar(50),
   UPDATE_TIME          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: 公司表                                                  */
/*==============================================================*/
create table COMPANY
(
   ID                   varchar(32) not null,
   NAME                 varchar(50),
   ADDRESS              varchar(100),
   STATUS               smallint(1),
   CREATE_BY            varchar(50),
   CREATE_TIME          datetime,
   UPDATE_BY            varchar(50),
   UPDATE_TIME          datetime,
   primary key (ID)
);