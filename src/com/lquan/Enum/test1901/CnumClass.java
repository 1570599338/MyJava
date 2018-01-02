package com.lquan.Enum.test1901;

public class CnumClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(Shrubbery s :Shrubbery.values()) {
			System.out.println(s + " ordinal: "+s.ordinal());
			System.out.print(s.compareTo(Shrubbery.CRAWLING)+"  ");
			System.out.print(s.equals(Shrubbery.CRAWLING)+"  ");
			System.out.println(s == Shrubbery.CRAWLING);
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
			System.out.println("**************************************");
		}
		
		System.out.println("-----------------------------------------------");
		//        GROUND,CRAWLING,HANGING
		for(String  s:"HANGING,CRAWLING,GROUND".split(",")) {
			Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shrub);
			
		}

	}

}
