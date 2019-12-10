drop table if exists t_goods;


create table t_goods
(
   id                   int not null,
   goods_name           varchar(200),
   model                varchar(50),
   unit                 varchar(10),
   price                int,
   stock                int,
   old_price            int,
   total_price          int,
   state                int comment '1:正常 2:删除',
   update_time          datetime,
   create_time          datetime,
   primary key (id)
);

alter table t_goods comment '商品表';


drop table if exists t_order;

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order
(
   id                   int not null,
   goods_id             int,
   flag                 varchar(1) comment '1:入库 0:出库',
   num                  int,
   price                int,
   total_price          int,
   create_time          datetime,
   state                int comment '1:正常 0:删除',
   update_time          datetime,
   primary key (id)
);

alter table t_order comment '订单表';
