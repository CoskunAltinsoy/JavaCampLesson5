package core.emailVerification;



public class EmailManager implements EmailService{

	@Override
	public void sendVerification(String email) {
		System.out.println(email+" adresine do�rulama postas� g�nderildi:");
	}

	@Override
	public boolean verifiedEmail(String option) {
		if (option.equals("Do�rula")) {
			System.out.println("Mail adresiniz do�ruland�.");
			return true;
		}		
	    	System.out.println("Mail adresiniz do�rulanamad�.");			
	    	return false;
		
	}

}
