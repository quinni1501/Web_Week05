package vn.iotstar.models;

import java.io.Serializable;

public class RolesModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5141584321305608359L;
	
	private int roleid;
	private String roleuname;
	/**
	 * 
	 */
	public RolesModel() {
		super();
	}
	
	
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRoleuname() {
		return roleuname;
	}
	public void setRoleuname(String roleuname) {
		this.roleuname = roleuname;
	}


	@Override
	public String toString() {
		return "RolesModel [roleid=" + roleid + ", roleuname=" + roleuname + "]";
	}
	
	
	
	

}
