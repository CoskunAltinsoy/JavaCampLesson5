package core.emailVerification;

public interface EmailService {
	void sendVerification(String email);
	boolean verifiedEmail(String email);

}
