package business.concretes;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserService;
import core.adapters.AuthService;

import core.emailVerification.EmailService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {
	UserDao userDao;
	EmailService emailService;
	AuthService authService;

	public UserManager(UserDao userDao, EmailService emailService, AuthService authService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
		this.authService = authService;
	}

	@Override
	public void add(User user) {	
		
		if (checkFullname(user) != true) {
			return;
		}
		else if(checkEmail(user) != true) {
			return;
		}
		else if(checkPassword(user) != true) {
			return;
		}
		else{
			
			this.emailService.sendVerification(user.getEmail());
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("E-mail adresinizi 'Doðrula' yazarak doðrulayabilirsiniz:");
			String option = scanner.nextLine();
			
			if (this.emailService.verifiedEmail(option)) {
				this.userDao.add(user);	
			} else {
				System.out.println("Kayýt iþleminiz baþarýsýz");
			}
		    		
		}
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public User getUser(int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {	
		return userDao.getAll();
	}

	@Override
	public void loginByGoogle(User user) {
		this.authService.login(user.getEmail());
	}
	
	public boolean checkPassword(User user) {
		if (user.getPassword().length()>=6) {
			return true;
		}else return false;
	}
	
	public boolean checkEmail(User user) {
		Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		Matcher matcher = pattern.matcher(user.getEmail());
		if (matcher.matches()) {
			return true;
		}else return false;
		
	}
	
	public boolean checkFullname(User user) {
		if (user.getFirstName().length()>=2 && user.getLastName().length()>=2) {
			return true;
		}else return false;
	}
	

}
