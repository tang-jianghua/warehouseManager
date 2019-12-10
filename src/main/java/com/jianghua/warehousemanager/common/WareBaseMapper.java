package com.jianghua.warehousemanager.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

//FIXME 特别注意，该接口不能被扫描到，否则会出错
public interface WareBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
