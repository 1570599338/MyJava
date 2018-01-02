/**
 * Create time 2012-5-8 上午10:28:48
 */


import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Title: BaseUtils
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author 阴磊
 * @version 1.0
 */
public class BaseUtils {

	private static final String EMPTY_TEXT = "";
	private static final String REGEX_MAIL = "^\\+?[A-Za-z0-9](([-+.]|[_]+)?[A-Za-z0-9]+)*@([A-Za-z0-9]+(\\.|\\-))+[A-Za-z]{2,6}$";
	private static final String REGEX_PHONE = "^(\\([0-9]+\\))?[0-9]{7,8}$";
	private static final String REGEX_MOBILE = "^(\\+[0-9]+)?[0-9]{11}";
	private static final String REGEX_NUM = "^\\d+$";
	private static final java.util.Map<Class, Map<String, Field>> clsFieldsMap = new HashMap<Class, Map<String, Field>>();
	public static final long DAY_MILLI = 24 * 60 * 60 * 1000; // 一天的MilliSecond
																// 数
	public static final long HOUR_MILLI = 60 * 60 * 1000; // 一XIAOSHI的MilliSecond
	public static final long MINUTE_MILLI = 60 * 1000; // 数
	/**
	 * 验证空白文本信息
	 * 
	 * @param text
	 *            文本
	 * @return 是否为空白
	 */
	public static boolean emptyText(String text) {
		return text == null || EMPTY_TEXT.equals(text);
	}

	/**
	 * 验证邮件
	 * 
	 * @param mail
	 *            邮件文本
	 * @return 是否为mail
	 */
	public static boolean checkMail(String mail) {
		return baseCheck(mail, REGEX_MAIL);
	}

	/**
	 * 验证座机电话
	 * 
	 * @param phone
	 *            电话文本
	 * @return 是否为电话
	 */
	public static boolean checkPhone(String phone) {
		return baseCheck(phone, REGEX_PHONE);
	}

	/**
	 * 验证移动电话
	 * 
	 * @param mobile
	 *            移动电话文本
	 * @return 是否为移动电话
	 */
	public static boolean checkMobile(String mobile) {
		return baseCheck(mobile, REGEX_MOBILE);
	}

	/**
	 * 验证数值
	 * 
	 * @param num
	 *            数值
	 * @return 是否为数值
	 */
	public static boolean checkNum(String num) {
		return baseCheck(num, REGEX_NUM);
	}

	/*
	 * 验证符合规则的字符
	 */
	private static boolean baseCheck(String v, String regex) {
		return v != null && v.matches(regex);
	}

	/**
	 * 生成32位UUID
	 */
	public static String generateUUID32() {
		return generateUUID(32);
	}

	// 生成指定长度的UUID
	public static String generateUUID(int length) {
		return UUID.randomUUID().toString().replaceAll("-", "")
				.substring(0, length).toUpperCase();
	}

	/**
	 * 生成商品流水号
	 * 
	 * @return
	 */
	public static String generateGoodsBn() {
		return generateUUID32();
	}

	/**
	 * 生成询价单编号
	 * 
	 * @return
	 */
	public static String generateOfferNo() {
		return generateUUID(11);
	}

	/**
	 * 生成报价单编号
	 * 
	 * @return
	 */
	public static String generateTenderNo() {
		return generateUUID32();
	}

	// ----------------------------- date util
	// ---------------------------------------------

	private static final String DATE_FORMAT_REGEX = "yyyy-MM-dd";
	private static final String TIME_FORMAT_REGEX = "yyyy-MM-dd HH:mm:ss";
	private static final String CHINESE_FORMAT_REGEX = "MM月dd日";

	/**
	 * 转换日期字符串，格式：MM月dd日
	 */
	public static String changeChineseMouthDay(Date date) {
		final DateFormat CHINESE_FORMAT = new SimpleDateFormat(
				CHINESE_FORMAT_REGEX);
		return CHINESE_FORMAT.format(date);
	}

	/**
	 * 转换为日期字符串，格式：yyyy-MM-dd
	 */
	public static String changeToDateString(Integer date) {
		if (date == null)
			return null;
		final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_REGEX);
		return DATE_FORMAT.format(changeIntToDate(date));
	}

	/**
	 * 转换为时间字符串，格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String changeToTimeString(Integer date) {
		if (date == null)
			return null;
		return changeDateToTimeString(changeIntToDate(date));
	}

	/**
	 * 将秒时转换为时间类型
	 */
	public static Date changeToDate(Integer date) {
		if (date == null)
			return new Date();
		return changeIntToDate(date);
	}

	/*
	 * 将整型时间转换为Date类型
	 */
	private static Date changeIntToDate(int date) {
		return new Date(date * 1000L);
	}

	/**
	 * 将Date转换为秒时
	 */
	public static int changeDateToInt(Date date) {
		return (int) (date.getTime() / 1000);
	}

	/**
	 * 将字符串的日期转换为int
	 */
	public static int changeStringDateToInt(String date) {
		return changeDateToInt(changeStringTimeToDate(date));
	}

	/**
	 * 将字符串的时间转换为int
	 */
	public static int changeStringTimeToInt(String date) {
		if (emptyText(date))
			return 0;
		return changeDateToInt(changeStringTimeToDate(date));
	}

	/**
	 * 将字符串的时间转换为date，舍弃时分秒
	 */
	public static final Date changeStringDateToDate(String date) {
		final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_REGEX);
		try {
			return DATE_FORMAT.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将字符串的时间转换为date,带有时分秒
	 */
	public static final Date changeStringTimeToDate(String date) {
		final DateFormat DATE_FORMAT = new SimpleDateFormat(TIME_FORMAT_REGEX);
		try {
			return DATE_FORMAT.parse(date);
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 将date时间转化为字符串 格式yyyy-MM-dd
	 */
	public static final String changeDateTimeToString(Date date) {
		if (date == null)
			return null;
		final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_REGEX);
		return DATE_FORMAT.format(date);
	}

	/**
	 * 将Date时间转换为字符串 yyyy-MM-dd hh:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static final String changeDateToTimeString(Date date) {
		if (date == null)
			return null;
		final DateFormat TIME_FORMAT = new SimpleDateFormat(TIME_FORMAT_REGEX);
		return TIME_FORMAT.format(date);
	}

	/**
	 * 获取当前系统时间，格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentTime() {
		return changeDateToTimeString(getNowDate());
	}

	/**
	 * 获得当前系统的秒时数
	 */
	public static int getNowSecond() {
		return changeDateToInt(getNowDate());
	}

	public static Date getNowDate() {
		return new Date();
	}

	/**
	 * 去掉时分秒
	 */
	public static Date exchangeDate(Date d) {
		return changeStringDateToDate(changeDateTimeToString(d));
	}

	/**
	 * @param offset
	 * @return
	 */
	public static Date getDate(int offset) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, offset);
		return c.getTime();
	}

	/**
	 * 获取当前时间的前后某一天，无时分秒
	 * 
	 * @param offset
	 *            游标；前为负数，后为正数
	 */
	public static Date getDateByDate(int offset) {
		return exchangeDate(getDate(offset));
	}

	/**
	 * 获得当前小时
	 */
	public static int getCurrentHour() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}

	public static int isCommonDate(Date d1, Date d2) {
		return d1.compareTo(d2);
	}

	/**
	 * 日期转XMLGregorianCalendar
	 * 
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		XMLGregorianCalendar gc = null;
		try {
			gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gc;
	}

	/**
	 * XMLGregorianCalendar转日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertToDate(XMLGregorianCalendar xmlDate) {
		if (xmlDate != null) {
			GregorianCalendar ca = xmlDate.toGregorianCalendar();
			return ca.getTime();
		}
		return null;
	}

	// ----------------- DATE UTIL END -----------------------------

	/**
	 * 处理url中的中文参数
	 */
	public static String decodeUrl(String value) {
		try {
			return URLDecoder.decode(value, "UTF-8");
		} catch (Exception e) {
			return value;
		}
	}

	// --------------------------- number util
	// ------------------------------------
	/**
	 * 获得实际的整数，默认为0
	 */
	public static Integer realInt(Integer i) {
		return realInt(i, 0);
	}

	/**
	 * 获得实际的整数
	 * 
	 * @param i
	 *            整数
	 * @param defval
	 *            默认值
	 */
	public static Integer realInt(Integer i, int defval) {
		return i == null ? defval : i;
	}

	/**
	 * 获得实际的double值，默认值为0
	 */
	public static Double readDouble(Double d) {
		return readDouble(d, 0);
	}

	/**
	 * 获得实际的double值
	 * 
	 * @param defval
	 *            默认值
	 */
	public static Double readDouble(Double d, double defval) {
		return d == null ? defval : d;
	}

	/**
	 * 取得两个日期之间的日数
	 * 
	 * @author Administrator
	 * @return t1到t2间的日数，如果t2 在 t1之后，返回正数，否则返回负数
	 */
	public static long daysBetween(java.sql.Timestamp t1, java.sql.Timestamp t2) {
		return (t2.getTime() - t1.getTime()) / DAY_MILLI;
	}

	/**
	 * 取得两个日期之间的
	 * 
	 * @author Administrator
	 * @return t1到t2间的日数，如果t2 在 t1之后，返回正数，否则返回负数
	 */
	public static long daysBetweenForHour(java.sql.Timestamp t1,
			java.sql.Timestamp t2) {
		return (t2.getTime() - t1.getTime()) / HOUR_MILLI;
	}

	/**
	 * 取得两个日期之间的分钟数
	 * 
	 * @author Administrator
	 * @return t1到t2间的分钟数，如果t2 在 t1之后，返回正数，否则返回负数
	 */
	public static long daysBetweenForHourMinute(java.sql.Timestamp t1,
			java.sql.Timestamp t2) {
		return (t2.getTime() - t1.getTime()) / MINUTE_MILLI;
	}

	public static long daysBetween(java.util.Date t1, java.util.Date t2) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(t2);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, 1);
		Date now = calendar.getTime();

		calendar.setTime(t1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date before = calendar.getTime();
		Timestamp time1 = new Timestamp(before.getTime());
		Timestamp time2 = new Timestamp(now.getTime());
		return daysBetween(time1, time2);
	}

	public static long daysBetweenForHour(java.util.Date t1, java.util.Date t2) {
		Timestamp time1 = new Timestamp(t1.getTime());
		Timestamp time2 = new Timestamp(t2.getTime());
		return daysBetweenForHour(time1, time2);
	}

	public static long daysBetweenForMinute(java.util.Date t1, java.util.Date t2) {
		Timestamp time1 = new Timestamp(t1.getTime());
		Timestamp time2 = new Timestamp(t2.getTime());
		return daysBetweenForHourMinute(time1, time2);
	}

	/**
	 * 判断字符是否为空，如果对象为null或者对象的值为"null"或者对象值为""，返回true，否则返回false
	 * 
	 * @param str
	 * @return
	 * @author Administrator
	 */
	public static boolean isEmpty(String str) {
		return (str == null) || "null".equals(str) || "".equals(str);
	}

	/**
	 * 判断字符是否为空，如果对象不为null且对象的值不为"null"且对象值不为""，返回true，否则返回false
	 * 
	 * @param str
	 * @return
	 * @author Administrator
	 */
	public static boolean isNotEmpty(String str) {
		return (str != null) && !"null".equals(str) && !"".equals(str);
	}

	/**
	 * 将金额转换为千分位显示
	 * 
	 * @param money
	 * @return
	 * @author Administrator
	 */
	public static String getSpecialMoney(Double money) {
		DecimalFormat f = new DecimalFormat(",##0.00");
		String specialMOney = f.format(money);
		System.out.println(specialMOney);
		return specialMOney;
	}

	/**
	 * 将Double型四舍五入，只保留小数点两位
	 */
	public static double doubleToDouble(double num) {
		NumberFormat form = NumberFormat.getInstance();
		if (form instanceof DecimalFormat) {
			((DecimalFormat) form).applyPattern("#0.00#");
			((DecimalFormat) form).setMaximumFractionDigits(2);
		}
		String value = form.format(num);
		return Double.parseDouble(value);
	}

	/**
	 * DecimalFormat转换最简便
	 */
	public static String doubleValue2(double num) {
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(num);
	}
	
	/**
	 * 保留三位小数非四舍五入
	 */
	public static String doubleValue3(double num) {
		DecimalFormat formater = new DecimalFormat();
		formater.setMaximumFractionDigits(3);
		formater.setGroupingSize(0);
		formater.setRoundingMode(RoundingMode.FLOOR);
		return formater.format(num);
	}
	/**
	 * DecimalFormat转换最简便
	 */
	public static String doubleValue1(double num) {
		DecimalFormat df = new DecimalFormat("#0.0");
		return df.format(num);
	}
	/**
	 * 将金额四舍五入并转换为千分位显示
	 * 
	 * @param money
	 * @return
	 * @author Administrator
	 */
	public static String roundAndComma(Double num) {
		return getSpecialMoney(doubleToDouble(num));
	}

	public static void main(String[] args) {
		System.out.println(doubleToDouble(0.006));
		System.out.println(doubleToDouble(0.004));
		System.out.println(doubleValue3(0.3698));

	}

	/** 计算结束时间，date下单时间，timeLong产品期限，timeUnit产品期限单位 */
	public static Date getEndTime(Date date, String timeLong, String timeUnit) {
		Calendar calendar = Calendar.getInstance();
		if ("Y".equals(timeUnit)) {
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, Integer.parseInt(timeLong));
		} else if ("M".equals(timeUnit)) {
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, Integer.parseInt(timeLong));
		} else {
			calendar.setTime(date);
			calendar.add(Calendar.DATE, Integer.parseInt(timeLong));
		}
		return calendar.getTime();
	}
	
	/** 计算结束时间，date下单时间，timeLong产品期限，timeUnit产品期限单位 */
	public static Date getEndTime(Date date, int timeLong, String timeUnit) {
		Calendar calendar = Calendar.getInstance();
		if ("Y".equals(timeUnit)) {
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, timeLong);
		} else if ("M".equals(timeUnit)) {
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, timeLong);
		} else {
			calendar.setTime(date);
			calendar.add(Calendar.DATE, timeLong);
		}
		return calendar.getTime();
	}

	// 保留后四位
	public static String numberFormat(Double d) {
		DecimalFormat f = new DecimalFormat(",##0.0000");
		f.setGroupingUsed(false);
		String str = f.format(d);
		// System.out.println(str);
		return str;
	}

	/**
	 * 过滤数值类型（double,float....）中的科学技术法 (注：以便以后可扩展及页面处理方便) 另注：float
	 * 类型的如果小数点保留六位，数值也会出错。 例如（7775.54f 转化后为：“7775.540039”）
	 * 
	 * @param num
	 * @return
	 */
	public static String numberToString(Object obj) {
		DecimalFormat df = null;
		if (obj instanceof Double) {
			df = new DecimalFormat("##.##");
		}
		if (obj instanceof Float) {
			df = new DecimalFormat("##.##");
		}
		return df.format(obj);
	}

	// --------------------------- number util end
	// ------------------------------------

	public static String mobileHiddenMiddle(String mobile) {

		return mobile.substring(0, 3) + "****"
				+ mobile.substring(7, mobile.length());
	}

	public static String idCardNoHiddenMiddle(String idCardNo) {

		return idCardNo.substring(0, 8) + "******"
				+ idCardNo.substring(14, idCardNo.length());
	}

	/**
	 * 将bigDecimal型数据四舍五入
	 * 
	 * @param bigDecimal
	 *            要处理的数据
	 * @param i
	 *            小数点保留位数
	 */
	public static double bigDecimalToDouble(BigDecimal bigDecimal, int i) {
		return bigDecimal.setScale(i, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * @param bigDecimal
	 *            要处理的数据
	 */
	public static BigDecimal DoubleToBigDecimal(Double num) {
		BigDecimal bg = new BigDecimal(num);
		return bg;
	}

	public static double doubleValue2FLOOR(double profit) {
		DecimalFormat formater = new DecimalFormat();
		formater.setMaximumFractionDigits(2);
		formater.setGroupingSize(0);
		formater.setRoundingMode(RoundingMode.FLOOR);
		return Double.parseDouble(formater.format(profit));
	}
	
	
	 // 判断手机号
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"); 
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    
    
    public static boolean is_chinese(String chineseContent) {  
        if(chineseContent==null) return false;  
        return chineseContent.matches("[\u4e00-\u9fa5]");  
    }  
    
    
    

    public static void cacheFields(Class cls) {
		if (clsFieldsMap.containsKey(cls)) {
			return;
		}
		Map<String, Field> map = new HashMap<String, Field>();
		Field[] fields = cls.getDeclaredFields();
		if (fields != null) {
			for (Field field : fields) {
				field.setAccessible(true);
				map.put(field.getName(), field);
			}
		}
		clsFieldsMap.put(cls, map);
	}
	
	/**
	 * 
	 * @param source 源对象
	 * @param dest	目标对象
	 */
	public static void copyProperties(Object source, Object dest) {
		Class sourceCls = source.getClass();
		Class destCls = dest.getClass();
		cacheFields(sourceCls);
		cacheFields(destCls);
		Map<String, Field> sfieldmap = clsFieldsMap.get(sourceCls);
		Map<String, Field> dfieldmap = clsFieldsMap.get(destCls);
		for (String field : sfieldmap.keySet()) {
			if (dfieldmap.containsKey(field)) {
				try {
					Object value = sfieldmap.get(field).get(source);
					if (value != null) {
						dfieldmap.get(field).set(dest, value);
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
