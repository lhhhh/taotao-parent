package some;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class normalTest {
	
	@Test
	@SuppressWarnings("rawtypes")
	public void test() {
		HashMap<String, Object> maps = new HashMap<String, Object>();
		
		Object result = maps.put("0", new String("init String"));
		System.out.println(result);
		Object result1 = maps.put("0", "100");
		System.out.println(result1);
		
		Iterator it = maps.entrySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(1);
//		list.add(3);
//		
//		//通过treeSet去重并排�?
//		list = new ArrayList<Integer>(new TreeSet<Integer>(list));
//		for(Integer i : list){
//			System.out.println(i);
//		}
	}
	
	@Test
	public void test1(){
		Bird b = new BirdOne();
		System.out.println(b.getName());
	}
	
	@Test
	public void test2() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Set<Date> dates = new TreeSet<Date>();
//		dates.add(sdf.parse("2016-11-24"));
//		dates.add(sdf.parse("2016-11-25"));
//		dates.add(sdf.parse("2016-10-24"));
//		dates.add(sdf.parse("2017-11-24"));
//		for(Date date: dates){
//			System.out.println(sdf.format(date)+"--hashCode:"+date.hashCode());
//		}
		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(sdf.parse("2016-11-11"));
//		System.out.println(cal.getTime());
//		cal.add(Calendar.DATE, -12);
//		System.out.println(cal.getTime());
//		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		
		String str = "1234567892";
		System.out.println(str.lastIndexOf('2'));
		System.out.println(str.matches("[1-9]{10}"));
	}
	
	@Test
	public void test3(){
		ExecutorService exec = Executors.newFixedThreadPool(2);   
		for(Integer index = 0; index < 100; index++) {   
			Runnable run = new Runnable() {   
				public void run() {   
					long time = (long) (Math.random() * 1000);   
					System.out.println("Sleeping " + time + "ms");   
					try {   
						Thread.sleep(time);   
					} catch (InterruptedException e) {   
					}   
				}   
			};
			exec.execute(run);   
		}
	}

	@Test
	public void test4(){
		Map<Integer, String> maps = new HashMap<Integer, String>();
		maps.put(1, "01");
		maps.put(2, "02");
		maps.put(3, "03");
		maps.put(4, "04");
		maps.put(5, "05");
		System.out.println(maps.values());
	}
	
	@Test
	@SuppressWarnings({ "static-access" })
	public void test5() throws Exception{
		Bird bo = new BirdOne();
		Class<?> clazz = getClass().forName(bo.getClass().getName());
		Method invoke = clazz.getMethod("setName",String.class);
		invoke.invoke(clazz,"newName");
		bo.getName();
	}
	
}
