package com.zwc.shiro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class ShiroApplicationTests {

	@Test
	public void contextLoads() {
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("39.106.130.199",6379);
		jedis.auth("123456");
		jedis.get("a");
		System.err.println(getNextDate());
	}
	
	//获取明天的时间
	public static String getNextDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟 
		Calendar cal = Calendar.getInstance();
		Date time = null;
		try {
			time = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.setTime(time);
		//+1 = 明天0:00
		cal.add(Calendar.DATE, 1);
		return sdf.format(cal.getTime());
	}
	
}
