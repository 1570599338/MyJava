package com.lquan.Enum.test1901;



public enum Ozwitch {
	WEST("miss Gulch ,aka the Wicked With Of the west"),
	NORTH("GLINDA,THE GOOD WITH OF THE NORTH");
	
	private String description;
	private Ozwitch(String description) {
		this.description=description;
	}
	
	
	public String getDescription() {
		return description;
	}
	public static  void main(String [] args) {
		System.out.println(Ozwitch.WEST.getDescription());
		
		for(Ozwitch  s:Ozwitch.values()) {
			System.out.println(s + " ordinal: "+s.getDescription());
			
		}
	}

}
