/**
 *
 */
package tr.biz.vardar.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KUTAY
 *
 */
public class DemoDataGenerator {

	public static List<User> generate() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User(Integer.toUnsignedLong(1), "kty", "Kutay", "Etçi", "20802439", "Computer Science", false));
		return userList;
	}
}
