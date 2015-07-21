package tr.biz.vardar.domain;


public class User {

	private Long id;
	private String username;
	private String password;
	private String fullname;
	private String name;
	private String surname;
	private String ssn;
	private String description;
	private String region;
	private String department;
	private boolean admin;
	private Address address;

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param fullname
	 * @param name
	 * @param surname
	 * @param ssn
	 * @param description
	 * @param region
	 * @param department
	 * @param admin
	 * @param address
	 */
	public User(Long id, String username, String password, String fullname,
			String name, String surname, String ssn, String description,
			String region, String department, boolean admin, Address address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.name = name;
		this.surname = surname;
		this.ssn = ssn;
		this.description = description;
		this.region = region;
		this.department = department;
		this.admin = admin;
		this.address = address;
	}

	/**
	 *
	 */
	public User() {
		super();
	}



	public User(Long id) {
		super();
		this.id = id;
	}

	public User get() {
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
