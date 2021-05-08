package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {
	List<User> users = new ArrayList<>();

	@Override
	public void add(User user) {
		this.users.add(user);
		System.out.println(user.getFirstName() + user.getLastName()+" bilgileriniz eklendi.");
	}

	@Override
	public void delete(User user) {
		this.users.remove(user);
		System.out.println(user.getFirstName() + user.getLastName()+" bilgileriniz silindi.");
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + user.getLastName()+" bilgileriniz güncellendi.");
		
	}

	@Override
	public User get(int id) {
		for (User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {	
		return users;
	}

}
