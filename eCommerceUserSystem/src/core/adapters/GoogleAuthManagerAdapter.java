package core.adapters;

import googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService{

	@Override
	public void login(String email) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.login(email);	
	}

}
