package net.proselyte.springbootdemo_311;

import net.proselyte.springbootdemo_311.model.Role;
import net.proselyte.springbootdemo_311.model.User;
import net.proselyte.springbootdemo_311.service.RoleService;
import net.proselyte.springbootdemo_311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application {
	private final RoleService roleService;

	private final UserService userService;

	@Autowired
	public Application(RoleService roleService, UserService userService) {
		this.roleService = roleService;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void createRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRole("ROLE_ADMIN");
		roleService.createRole(adminRole);

		Role userRole = new Role();
		userRole.setRole("ROLE_USER");
		roleService.createRole(userRole);

		User user1 = new User();
		user1.setName("Aktilek");
		user1.setSurname("Kanybekov");
		user1.setEmail("a.kanibekov19@gmail.com");
		user1.setPost("admin");
		user1.setUsername("centurion");
		user1.setPassword("SIMsim01");

		Set<Role> userRoles = new HashSet<>();
		userRoles.add(adminRole);
		user1.setRoles(userRoles);
		user1.addRole(adminRole);
		userService.createUser(user1);

	}
}
