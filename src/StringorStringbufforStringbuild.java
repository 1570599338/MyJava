/**
 * Title   StringorStringbufforStringbuild.java
 * Descr   String StringBuffer 还有StringBuild三者区别。
 * 		StringBffer是线程关键字。
 * 		StringBuild是非线程安全的。
 * Email   lquan.liu@outlook.com 
 * @author lquan
 * @dates  2017年11月15日 上午12:37:22
 */
public class StringorStringbufforStringbuild {

	public static void main(String[] args) {
		String aaString ="AAAA";
		
		/**
		 * StringBuffer 底层实现：在new的时候是一个默认16个字符数组。底层当底层长度不足后他会更具拼接的字符串的长度区重新区新建一个长度的数组
		 * 以为StringBuffer的方法类中有关键字synchronized所以是线程安全的
		 */
		StringBuffer sbBuffer = new StringBuffer();
		
		
		/**
		 * StringBuilder 底层实现和StringBuffer一样的唯一区别就是他的类方法没有synchronized关键字所以他不是线程安全的。
		 */
		StringBuilder sBuilder=new StringBuilder();

	}

}
