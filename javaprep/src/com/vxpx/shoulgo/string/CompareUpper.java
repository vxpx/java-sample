package com.vxpx.shoulgo.string;

class MyObject {
	int id;
	String name;
	
	MyObject(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	void addressCopy(MyObject obj) {
		//obj = new MyObject(2,"sxroy");
		obj.name = "vxpx1";
		
	}

	@Override
	public String toString() {
		return "MyObject [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyObject other = (MyObject) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}

public class CompareUpper {
	
	public static void main(String[] args) {
		
		
		String s = "abc";
		
		String upper = s.toUpperCase();
		
		if (s.compareTo(s) == 0) {
			System.out.println("Strings are same using compareto");
		}
		
		System.out.println(s.compareTo(upper));
		System.out.println(upper.compareTo(s));
		System.out.println("b".compareTo("u"));
		
		MyObject myobject = new MyObject(1,"vxpx");
		
		System.out.println(myobject);
		
		myobject.addressCopy(myobject);
		
		System.out.println(myobject);
		
		
	}
	
	

}
