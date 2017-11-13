import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Title   Test.java
 * Descr   测试hashMap的，查看源码理解hashMap的原理
 * Email   lquan.liu@outlook.com 
 * @author lquan
 * @dates  2017年11月12日 下午7:20:59
 */
public class Test {
	public static void 打印(){
		System.out.println("*******");
	}

	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		
		
		
		//打印();
		 Map<String, String> m = new HashMap<String, String>();
//		 System.out.println("****"+m.put("1", "333"));
		 System.out.println(m.size());
		 m.put(null, "A");
		 m.put(null, "B");
		 m.put(null, "C");
		 m.put(null, "D");
		 
		 System.out.println(m.hashCode()+"----"+m.get(null)+"*****"+m.size());
		 
		 
		 // 0000 1100;
		 // 0001 0000;
//		 int number=3;
//		 int aa = Integer.highestOneBit((number) << 1);
//		 System.out.println("^^^^^^:"+aa);
//		 
		 
//		 long aa = 0X200000043l;
//			System.out.println(aa);
//			
//		String aString  = new String("aaaaa");

	}

}
