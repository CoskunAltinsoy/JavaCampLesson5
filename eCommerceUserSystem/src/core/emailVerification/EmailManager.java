package core.emailVerification;



public class EmailManager implements EmailService{

	@Override
	public void sendVerification(String email) {
		System.out.println(email+" adresine doðrulama postasý gönderildi:");
	}

	@Override
	public boolean verifiedEmail(String option) {
		if (option.equals("Doðrula")) {
			System.out.println("Mail adresiniz doðrulandý.");
			return true;
		}		
	    	System.out.println("Mail adresiniz doðrulanamadý.");			
	    	return false;
		
	}

}
