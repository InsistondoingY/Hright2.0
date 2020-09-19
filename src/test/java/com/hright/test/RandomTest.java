package com.hright.test;


import com.hright.tools.RandomNum;
import org.testng.annotations.Test;

/**
 * Created by lenovo on 2016/11/10.
 */
public class RandomTest {
    @Test
    public  void testNum(){
        RandomNum.getNumRandom(5);
    }
    @Test
    public  void testNum1(){
        RandomNum.getNumRandom1(1,20);
    }
    @Test
    public  void testString(){
        RandomNum.getStringRandom(9);
    }

}
