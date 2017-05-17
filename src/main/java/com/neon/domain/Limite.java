package com.neon.domain;

import java.util.Set;

public class Limite {
	private Long id;
	private String limiteName;
	private String actionName;
	private Limite parent;
	private Set<Limite> children;
	private Set<Role> roles;
	
	public Limite() {}
	
	public Limite(String limiteName, String actionName , Limite parent) {
		super();
		this.limiteName = limiteName;
		this.actionName = actionName;
		this.parent = parent;
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
	
	public Limite getParent() {
		return parent;
	}

	public void setParent(Limite parent) {
		this.parent = parent;
	}


	public Set<Limite> getChildren() {
		return children;
	}

	public void setChildren(Set<Limite> children) {
		this.children = children;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
