package com.idm.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UtenteVoLogin {

	@NotNull
	@Size(min=2,max=30)
	private String Username;

	@NotNull
	@Size(min=8,max=30)
	private String password;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UtenteVoLogin [Username=" + Username + ", password=" + password + "]";
	}



}
