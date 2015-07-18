package tr.biz.vardar.customtable;

public class User {

	private Long id;
	private String username;
	private String name;
	private String surname;
	private String ssn;
	private String department;
	private boolean admin;


	public User(Long id, String username, String name, String surname, String ssn, String department, boolean admin) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.ssn = ssn;
		this.department = department;
		this.admin = admin;
	}

	public String getFullname() {
		return surname + ", " + name;
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


	public User get() {
		return this;
	}
}
