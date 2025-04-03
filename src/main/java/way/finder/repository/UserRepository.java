package way.finder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import way.finder.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	@Query("select u from User u where u.username = ?1 and u.password = ?2")
	public User login(String username, String password);
	
}
