package com.hright.tools;

import com.hright.action.Action;
import com.hright.logger.LoggerControler;

import java.util.Random;


/**
 * Created by lenovo on 2016/11/10.
 */
public class RandomNum {
    final static LoggerControler log =LoggerControler.getlogger(RandomNum.class);

    public static long getNumRandom(int length){
        //随机数乘以10^n次方
        long num=0;
        num=(long)(Math.random()*Math.pow(10,length));
        log.info("随机数："+String.valueOf(num));
        return num;
    }

    public static long getNumRandom1(int min,int max){
        //如输出一个10~100之间的随机数
        long num=0;
        Random random=new Random();
        num=random.nextInt(max-min+1)+min;
        log.info("区间值的随机数："+String.valueOf(num));
        return num;
    }
    public static String getStringRandom(int length){
       String val="";
        Random random=new Random();
        for(int i = 0; i<length; i++){
            String charOrNum=random.nextInt(10)%2==0?"char":"num";
            if ("char".equals(charOrNum)){
                int temp=random.nextInt(10)%2==0?65:97;
                val+=(char)(random.nextInt(26)+temp);
            }else if ("num".equals(charOrNum)){
                val+=String.valueOf(random.nextInt(10));
            }
        }
        log.info("大小写字母加数字随机数："+val);
        return val;
    }


}
