package com.neon.domain;

import java.util.Set;

public class Limite {
	private long id;
	private String limiteName;
	private String actionName;
	private Set<Role> roles;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLimiteName() {
		return limiteName;
	}
	public void setLimiteName(String limiteName) {
		this.limiteName = limiteName;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
