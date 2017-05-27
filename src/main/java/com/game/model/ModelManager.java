package com.game.model;

import com.core.account.AccountManager;

public class ModelManager {
	private static ModelManager ince = null;
	
	private LoginModel login;
		
	public static ModelManager getInstance() {
		if (null == ince) {
			ince = new ModelManager();
		}
		return ince;
	}
	
	public void init(){
		AccountManager.getInstance();
		login = new LoginModel();
	}
	
	public void clear(){
		
	}

	public LoginModel getLogin() {
		return login;
	}
	
}
