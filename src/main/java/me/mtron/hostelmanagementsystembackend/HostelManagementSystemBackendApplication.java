package me.mtron.hostelmanagementsystembackend;

import me.mtron.hostelmanagementsystembackend.models.ApplicationUser;
import me.mtron.hostelmanagementsystembackend.models.Role;
import me.mtron.hostelmanagementsystembackend.repo.RoleRepo;
import me.mtron.hostelmanagementsystembackend.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HostelManagementSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostelManagementSystemBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder passwordEncoder){
		return args -> {
			if(roleRepo.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepo.save(new Role("ADMIN"));
			roleRepo.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1,"ADMIN/2019/001", "admin", "admin@mtron.biz", passwordEncoder.encode("password"), roles);

			userRepo.save(admin);
		};
	}
}
