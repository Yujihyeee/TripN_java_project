package shop.tripn.app.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import shop.tripn.app.demo.calculator.entity.User;
import shop.tripn.app.demo.calculator.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		userRepository.save(new User("a", "전우치", "a@", "1"));
		userRepository.save(new User("b", "강감찬", "b@", "1"));
		userRepository.save(new User("c", "홍길동", "c@", "1"));
		List<User> users = userRepository.findAll();
		System.out.println("전체를 출력하시오");
		for (User u: users){
			System.out.println(u.toString());
		}
		System.out.println("전우치만 출력하시오");
		for (User u:userRepository.findAllByName("전우치")){
			System.out.println(u.toString());
		}
	}
}