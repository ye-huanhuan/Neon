package com.neon.domain;

import java.util.Set;

public class Privilege {

	private Long id;
	private String limiteName;
	private String actionName;
	
	private Set<Role> roles;
	
	private Privilege parent;
	private Set<Privilege> children;
	
	public Privilege(){}
	
	
	public Privilege(String limiteName, String actionName, Privilege parent) {
		super();
		this.limiteName = limiteName;
		this.actionName = actionName;
		this.parent = parent;
	}



	public Long getId() {
		return id;
	}
	public String getLimiteName() {
		return limiteName;
	}
	public String getActionName() {
		return actionName;
	}
	public Set<Role> getRoles() {
		return roles;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setLimiteName(String limiteName) {
		this.limiteName = limiteName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Privilege getParent() {
		return parent;
	}
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

}
