package com.kent.datasource;

import com.kent.datasource.Mapper.TestMapper;
import com.kent.datasource.Mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author kongtong.ouyang on 2018/2/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:application-Context.xml"})
public class SpringBase {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TestMapper testMapper;

    @Test
    public void test1() {
        System.out.println(testMapper.count());
    }
}
