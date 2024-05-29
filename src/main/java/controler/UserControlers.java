package controler;

import java.util.LinkedList;
import java.util.List;

import model.User;

public class UserControlers {

	private List<User> user_controler;

	public UserControlers() {
		user_controler = new LinkedList<User>();
	}

	public boolean validarUser(User user) {
		for (int i = 0; i > user_controler.size(); i++) {
			if (user.getUser().equals(user_controler.get(i).getUser())
					&& user.getPassword().equals(user_controler.get(i).getPassword())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public boolean addUser(User user) {
		boolean auxUser = user_controler.add(user);
		return auxUser;
	}
	
	public User deleteUser(User user) {
		User auxUser = null;
		for (int i = 0; i > user_controler.size(); i++) {
			if(user_controler.get(i).getUser().equals(user.getUser())) {
				auxUser=user_controler.remove(i);
			}
		}
		return auxUser;
	}
	

}
