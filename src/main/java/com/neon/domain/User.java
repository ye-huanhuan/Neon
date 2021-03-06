package com.neon.domain;

import java.util.Collection;

import com.opensymphony.xwork2.ActionContext;

public class User {

	private Long id;
	private String username;
	private String password;
	private String email;
	private Role role;
	
	public User() {}
	
	public User(String username, String password, String email, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	//验证是否具有权限
	public boolean hasPrivilegeByName(String name){
		for(Privilege p : role.getPrivileges()){
			if(p.getLimiteName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	//验证是否具有权限
		public boolean hasPrivilegeByAction(String name){
			
			Collection<String> allPrivilegeUrls = (Collection<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
			if(!allPrivilegeUrls.contains(name)){
				return true;
			}else{
				for(Privilege p : role.getPrivileges()){
					if(p.getActionName().equals(name)){
						return true;
					}
				}
			}
			
			return false;
		}
	
	public boolean isNotPrivilege(String name){
		if("分析".equals(name)){
			return false;
		}else if("报表".equals(name)){
			return false;
		}
	return true;
		
	}
	
	public boolean isPrivilege(String name){
			if("分析".equals(name)){
				return true;
			}
		return false;
	}
	
	public boolean isPrivilege_2(String name){
		if("报表".equals(name)){
			return true;
		}
	return false;
}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
