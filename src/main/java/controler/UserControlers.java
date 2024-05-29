package controler;

import model.User;

public class UserControlers {
	
	private User user_controler;
	
	
	
	public boolean validarUser(User user) {
		if(user.getUser().equals(user_controler.getUser())&&user.getPassword().equals(user_controler.getPassword())){
			return true;
		}else{
		return false;
	}
 }
}
