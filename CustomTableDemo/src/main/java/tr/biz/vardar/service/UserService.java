/**
 *
 */
package tr.biz.vardar.service;

import tr.biz.vardar.domain.User;

/**
 * @author KUTAY
 *
 */
@org.springframework.stereotype.Service
public class UserService implements Service<User> {

	/* (non-Javadoc)
	 * @see tr.biz.vardar.service.Service#newInstance()
	 */
	@Override
	public User newInstance() {
		return new User(Integer.toUnsignedLong((int)(Math.random() * 100)));
	}

	/* (non-Javadoc)
	 * @see tr.biz.vardar.service.Service#save(java.lang.Object)
	 */
	@Override
	public void save(User t) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see tr.biz.vardar.service.Service#edit(java.lang.Object)
	 */
	@Override
	public void edit(User t) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see tr.biz.vardar.service.Service#delete(java.lang.Object)
	 */
	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub

	}

}
