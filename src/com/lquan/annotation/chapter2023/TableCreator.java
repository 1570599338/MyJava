package com.lquan.annotation.chapter2023;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * <p>Title:       TableCreator</p>
 * <p>Description: 实现处理器：一个注解处理器的例子，他将读取一个文件，检查其上的数据库注解，并
 * 				   生成用来创建数据库的SQL命令</p>
 * <p>Created by  lquan on Jan 4, 20182:37:58 PM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 */
public class TableCreator {

	public static void main(String[] args) throws Exception {
		// 判断是否有参数传入
		if(args.length<1) {
			System.out.println("arguments:annotated classes");
			System.exit(0);
		}
		
		// 有参数传入的member类的传入的情况下
		for(String className:args) {
			Class<?> cl = Class.forName(className);
			DBTable dbTable = cl.getAnnotation(DBTable.class);
			if (dbTable == null) {
				System.out.println("No DBTable anntations in class "+className);
				continue;
			}
			
			// 获取注解@表名
			String  tableName = dbTable.name();
			if (tableName.length() <1) 
				tableName = cl.getName().toUpperCase();// 表名全部转换成大写
			List<String> columnDefs = new ArrayList<String>();
			StringBuilder sql = new StringBuilder("CREATE TABLE " + tableName + "(");
			// 利用反射来获取所有的属性字段
			for(Field field :cl.getDeclaredFields()) {
				String  columnName = null;
				Annotation[] anns = field.getDeclaredAnnotations();// 获取每个属性字段的注解
				if (anns.length<1)
					continue;// Not a db table column
				
				// 判断属性的类型Integer类型
				if(anns[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) anns[0];
					// Use field name if name not specified
					if (sInt.name().length()<1) 
						columnName = field.getName().toUpperCase();
					else
						columnName = sInt.name();
					columnDefs.add(columnName+ " INT"+getConstraints(sInt.constraints()));
				}
				
				// 判断属性字段的类型为字符串类型
				if (anns[0] instanceof SQLString) {
					SQLString sqlString = (SQLString) anns[0];
					// Use field name if name not Specified.
					if(sqlString.name().length() <1)
						columnName = field.getName().toUpperCase();
					else
						columnName = sqlString.name();
					columnDefs.add(columnName+ " VARCHAR("+sqlString.value()+")"+getConstraints(sqlString.constraints()));
					}
				
				
				StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
				for(String columnDef:columnDefs) 
					createCommand.append("\n	  "+ columnDef + ",");
					// remove trailling comma
				String tableCreate = createCommand.substring(0,createCommand.length()-1) + "\n);";
				System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
				
			}
			
			System.out.println("T********************************************************************\n********************************************************" );
		
			for(String columnDef:columnDefs) 
				sql.append("\n	  "+ columnDef + ",");
				// remove trailling comma
			String tableCreate = sql.substring(0,sql.length()-1) + "\n);";
			System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
			
			
			
		}
	}
	
	
	private static String getConstraints(Constraints con) {
		String  constraints ="";
		if(!con.allowNull())
			constraints +=" NOT NULL";
		if(con.primaryKey())
			constraints +=" PRIMARY KEY";
		if(con.unique())
			constraints +=" UNIQUE";
		
		
		return constraints;
	}
}
