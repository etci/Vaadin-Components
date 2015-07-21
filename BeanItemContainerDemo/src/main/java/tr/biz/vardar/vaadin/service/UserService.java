package tr.biz.vardar.vaadin.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.beanutils.BeanUtils;

import tr.biz.vardar.vaadin.model.User;


public class UserService {

	// Create dummy data by randomly combining first and last names
	static String[] fnames = { "Peter", "Alice", "John", "Mike", "Olivia",
			"Nina", "Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene", "Lisa",
			"Linda", "Timothy", "Daniel", "Brian", "George", "Scott",
	"Jennifer" };
	static String[] lnames = { "Smith", "Johnson", "Williams", "Jones",
			"Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
			"Anderson", "Thomas", "Jackson", "White", "Harris", "Martin",
			"Thompson", "Young", "King", "Robinson" };

	private static UserService instance;

	public static UserService createDemoService() {
		if (instance == null) {

			final UserService userService = new UserService();

			Random r = new Random(0);
			Calendar cal = Calendar.getInstance();
			for (int i = 0; i < 100; i++) {
				User contact = new User();
				contact.setFirstName(fnames[r.nextInt(fnames.length)]);
				contact.setLastName(lnames[r.nextInt(fnames.length)]);
				contact.setEmail(contact.getFirstName().toLowerCase() + "@"
						+ contact.getLastName().toLowerCase() + ".com");
				contact.setPhone("+ 358 555 " + (100 + r.nextInt(900)));
				cal.set(1930 + r.nextInt(70),
						r.nextInt(11), r.nextInt(28));
				contact.setBirthDate(cal.getTime());
				userService.save(contact);
			}
			instance = userService;
		}

		return instance;
	}

	private static List<User> contacts = new ArrayList<User>();
	private long nextId = 0;

	public static List<User> getUserList(){
		return contacts;
	}

	public synchronized long count() {
		return contacts.size();
	}

	public synchronized void delete(User value) {
		contacts.remove(value.getId());
	}

	public synchronized void save(User entry) {
		if (entry.getId() == null) {
			entry.setId(nextId++);
		}
		try {
			entry = (User) BeanUtils.cloneBean(entry);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		contacts.add(entry);
	}

}
