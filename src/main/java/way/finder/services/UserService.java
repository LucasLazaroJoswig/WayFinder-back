package way.finder.services;

import org.springframework.stereotype.Repository;

import way.finder.entity.User;


public interface UserService {
	

	public User login(String username, String password);
	public User changePassword(Long id, String password);
}
