package com.hright.test;

import com.hright.tools.DateFormat;
import org.testng.annotations.Test;

/**
 * Created by lenovo on 2016/11/10.
 */
public class DateFormatTest {
    //按时间戳生成的随机数
    @Test
    public void DateTime(){
        DateFormat.format(DateFormat.CHECK_LOG_FORMAT);
    }
    //按时间戳生成N位的随机数
    @Test
    public void CuoTime(){
        DateFormat.time();
    }
}
