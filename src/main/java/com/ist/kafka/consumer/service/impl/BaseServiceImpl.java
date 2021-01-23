package com.ist.kafka.consumer.service.impl;

import com.ist.kafka.consumer.service.BaseService;
import org.slf4j.Logger;

import javax.annotation.Resource;
import java.util.Random;

public class BaseServiceImpl implements BaseService {
    @Resource(name="all_log")
    protected Logger logger;

    protected String getItemId(int len) {
        String val = "";
        Random random = new Random();
        for ( int i = 0; i <len; i++ )
        {
            String str = random.nextInt( 2 ) % 2 == 0 ? "num" : "char";
            if ( "char".equalsIgnoreCase( str ) )
            { // 产生字母
                int nextInt = random.nextInt( 2 ) % 2 == 0 ? 65 : 97;
                // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                val += (char) ( nextInt + random.nextInt( 26 ) );
            }
            else if ( "num".equalsIgnoreCase( str ) )
            { // 产生数字
                val += String.valueOf( random.nextInt( 10 ) );
            }
        }
        return val;
    }
}
