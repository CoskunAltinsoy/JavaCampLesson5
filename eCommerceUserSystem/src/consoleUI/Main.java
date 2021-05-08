package consoleUI;

import business.abstracts.UserService;
import business.concretes.UserManager;

import core.adapters.GoogleAuthManagerAdapter;
import core.emailVerification.EmailManager;


import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;


public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(), new EmailManager(), new GoogleAuthManagerAdapter());
		User user = new User(1, "Mücahit", "Altýnsoy", "coskun@123.com", "1234567890");	
		userService.add(user);

	}

}
