package core.emailVerification;



public class EmailManager implements EmailService{

	@Override
	public void sendVerification(String email) {
		System.out.println(email+" adresine doğrulama postası gönderildi:");
	}

	@Override
	public boolean verifiedEmail(String option) {
		if (option.equals("Doğrula")) {
			System.out.println("Mail adresiniz doğrulandı.");
			return true;
		}		
	    	System.out.println("Mail adresiniz doğrulanamadı.");			
	    	return false;
		
	}

}
