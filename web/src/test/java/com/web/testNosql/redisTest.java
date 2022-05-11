package com.web.testNosql;


import com.web.dao.EnjoyDao;
import com.web.service.MarkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class redisTest {

    // 这个注入方法不要用，这里涉及到redis序列化问题，造成在Java操作数据库乱码
//    @Autowired
//    private RedisTemplate redisTemplate;

    @Autowired
    MarkService markService;
    // 使用这个注入方法可解决乱码问题
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private EnjoyDao enjoyDao;

    @Test
    void set() {
        List<String> data = enjoyDao.getAllData();
        SetOperations<String, String> ops = stringRedisTemplate.opsForSet();
        String enjoyAllData = "enjoyAllData";
        for (String enjoy : data) {
            ops.add(enjoyAllData, enjoy);
        }

//        String enjoyAllData = "enjoyAllData";
//        HashOperations<String, Object, Object> ops = stringRedisTemplate.opsForHash();
//        ops.put(enjoyAllData, "1", "123");



    }

    @Test
    void get() {
        String enjoyAllData = "enjoyAllData";
        SetOperations<String, String> ops = stringRedisTemplate.opsForSet();
        Set<String> data = ops.members(enjoyAllData);
        for (String value : data) {
            System.out.print(value + " ");
        }
    }

}
