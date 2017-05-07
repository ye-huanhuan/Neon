package com.neon.domain;

import java.util.Set;

public class Role {
	private long id;
	private String roleName;
	private Set<Limite> limites;
	private Set<User> users;
	
	public Role() {}
	
	public Role(String roleName, Set<Limite> limites, Set<User> users) {
		super();
		this.roleName = roleName;
		this.limites = limites;
		this.users = users;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<Limite> getLimites() {
		return limites;
	}
	public void setLimites(Set<Limite> limites) {
		this.limites = limites;
	}
	
	
}
