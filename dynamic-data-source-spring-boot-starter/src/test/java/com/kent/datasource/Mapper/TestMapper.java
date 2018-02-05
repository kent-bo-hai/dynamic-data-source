package com.kent.datasource.Mapper;

import com.kent.datasource.annotation.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author kongtong.ouyang on 2018/2/2.
 */
@DataSource("test")
@MapperScan
@Mapper
public interface TestMapper {

    @Select("select count(*) from test")
    int count();
}

