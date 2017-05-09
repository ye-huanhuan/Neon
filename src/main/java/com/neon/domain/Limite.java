package com.neon.domain;

import java.util.Set;

public class Limite {
	private long id;
	private String limiteName;
	private String actionName;
	private Limite parent;
	private Set<Limite> children;
	private Set<Role> roles;
	
	public Limite() {}
	
	public Limite(String limiteName, String actionName , Set<Role> roles) {
		super();
		this.limiteName = limiteName;
		this.actionName = actionName;
		this.roles = roles;
	}
	
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

	public Limite getParent() {
		return parent;
	}

	public Set<Limite> getChildren() {
		return children;
	}

	public void setParent(Limite parent) {
		this.parent = parent;
	}

	public void setChildren(Set<Limite> children) {
		this.children = children;
	}


	
}
