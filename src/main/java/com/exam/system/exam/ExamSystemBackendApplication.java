package com.exam.system.exam;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.exam.system.exam.configuration.CorsConfiguration;

@SpringBootApplication
@Import(CorsConfiguration.class)
public class ExamSystemBackendApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamSystemBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * System.out.println("Contraseña: " +
		 * bCryptPasswordEncoder.encode("abcd1234"));
		 * User user = new User();
		 * user.setName("William");
		 * user.setSurname("Roa");
		 * user.setUsername("rwillian");
		 * user.setPassword("abcd1234");
		 * user.setEmail("rwillian@jdc.edu.co");
		 * user.setPhone("3202923666");
		 * user.setProfile("photo.jpg");
		 * 
		 * Rol rol = new Rol();
		 * rol.setRolId(1L);
		 * rol.setRolName("Admin");
		 * 
		 * Set<UserRol> userRols = new HashSet<>();
		 * 
		 * UserRol userRol = new UserRol();
		 * userRol.setRol(rol);
		 * userRol.setUser(user);
		 * 
		 * userRols.add(userRol);
		 * 
		 * User savedUser = userService.saveUser(user, userRols);
		 * System.err.println("User " + savedUser.getName());
		 */
	}
}
