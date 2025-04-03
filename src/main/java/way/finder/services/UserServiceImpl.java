package way.finder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import way.finder.entity.User;
import way.finder.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(String username, String password) {
		User user=userRepository.login(username, password);
		if (user!=null) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public User changePassword(Long id, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).orElse(null);
		if (user==null) {
			return null;
		} else {
			user.setPassword(password);
			userRepository.save(user);
			return user;
		}
	}



}
