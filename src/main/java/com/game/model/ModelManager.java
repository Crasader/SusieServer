package com.game.model;

import com.core.account.AccountManager;

public class ModelManager {
	private static ModelManager ince = null;
	
	private LoginModel login;
	private BattleModel scene;
		
	public static ModelManager getInstance() {
		if (null == ince) {
			ince = new ModelManager();
		}
		return ince;
	}
	
	public void init(){
		AccountManager.getInstance();
		login = new LoginModel();
		scene = new BattleModel();
	}
	
	public void clear(){
		
	}

	public LoginModel getLogin() {
		return login;
	}
	
	public BattleModel getScene(){
		return scene;
	}
	
}
