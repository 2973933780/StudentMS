package com.liu.model;

public enum UserType {
	ADMIN("ϵͳ����Ա",0),USER("�û�",1),VIPUSER("VIP���",2);
	private
		String name;int index;
		UserType(String name,int index)
		{
		this.name=name;
		this.index=index;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String toString() 
		{
			return this.name;	
		}
}
