package way.finder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import way.finder.entity.User;
import way.finder.services.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/login")
	public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password){
		User user=userService.login(username, password);
		if (user==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(user);
		}
	}
	
	@PutMapping("/changePassword/{id}")
	public ResponseEntity<User> changePassword(@PathVariable Long id, @RequestParam String password){
		User user = userService.changePassword(id, password);
		if (user==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(user);
		}
	}
}
