package br.com.tokenlab.challenge;

import br.com.tokenlab.challenge.entity.User;
import br.com.tokenlab.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TokenlabChallengeManagementOfEventsApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TokenlabChallengeManagementOfEventsApplication.class, args);
		//System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

	@Override
	public void run(String... args) {
		final String password = "$2a$10$oXxD3F3PL90OMYhj9OOtMO72tJCxevBiz1e5uE3l3JEyPEyKhgiaG";
		userRepository.save(new User("user01", password, "user_teste"));
	}
}
