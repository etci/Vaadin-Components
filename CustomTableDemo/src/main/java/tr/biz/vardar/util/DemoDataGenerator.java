/**
 *
 */
package tr.biz.vardar.util;

import java.util.ArrayList;
import java.util.List;

import tr.biz.vardar.domain.Address;
import tr.biz.vardar.domain.Apartment;
import tr.biz.vardar.domain.User;

/**
 * @author KUTAY
 *
 */
public class DemoDataGenerator {

	public static final int NUM_USERS = 100;
	public static List<User> generate() {
		List<User> userList = new ArrayList<User>();
		for (int i = 1; i <= NUM_USERS; i++) {
			Apartment apartment = new Apartment(Integer.toUnsignedLong(i), "ApartmentNo" + i, "ApartmentName" + i);
			Address address = new Address(Integer.toUnsignedLong(i), "Street" + i, "PostCode" + i, apartment);
			userList.add(new User(
					Integer.toUnsignedLong(i),
					"Username" + i,
					"Password" + i,
					"Fullname" + i,
					"Firstname" + i,
					"Lastname" + i,
					"Ssn" + i,
					"Description" + i,
					"Region" + i,
					"Department" + i,
					true,
					address));
		}

		return userList;
	}
}
