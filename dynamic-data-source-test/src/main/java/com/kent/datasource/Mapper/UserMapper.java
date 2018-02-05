package com.kent.datasource.Mapper;

import com.kent.datasource.annotation.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author kongtong.ouyang on 2018/2/2.
 */
@DataSource("user")
@MapperScan
@Mapper
public interface UserMapper {

    @Select("select count(*) from user")
    int count();
}

