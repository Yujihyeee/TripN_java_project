package shop.tripn.app.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import shop.tripn.app.demo.calculator.entity.Item;
import shop.tripn.app.demo.calculator.entity.User;
import shop.tripn.app.demo.calculator.repository.ItemRepository;
import shop.tripn.app.demo.calculator.repository.UserRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired private UserRepository userRepository;
	@Autowired private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("########## Application START ##########");
		userRepository.deleteAll();
		userRepository.save(new User(1, "a", "Peter", "a@a", "1", new Date()));
		userRepository.save(new User(2,"b", "Peter", "b@b", "1", new Date()));
		userRepository.save(new User(3, "c", "Bob", "c@c", "1",new Date()));
		List<User> users = userRepository.findAll();
		System.out.println("Print All Users");
		for (User u : users) {
			System.out.println(u.toString());
		}
		System.out.println("Print Only Bob");
		for (User u : userRepository.findAllByName("Bob")) {
			System.out.println(u.toString());
		}
		System.out.println("########## itemRepository START ##########");
		itemRepository.deleteAll();
		itemRepository.save(new Item(1, "galaxy", 1000000, "note", new Date()));
		itemRepository.save(new Item(2, "iphone", 2000000, "none", new Date()));
		itemRepository.save(new Item(3, "lg", 3000000, "work", new Date()));
		List<Item> items = itemRepository.findAll();
		System.out.println("Print All Items");
		for (Item i: items){
			System.out.println(i.toString());
		}
	}
}