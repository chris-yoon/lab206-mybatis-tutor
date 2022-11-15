package org.egovframe.lab.ex;

public class CustomerVO {
	private String id;
	private String name;
	private String address;
	public String getAddress() {
		return address;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
