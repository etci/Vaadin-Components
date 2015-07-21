/**
 *
 */
package tr.biz.vardar.domain;


/**
 * @author KUTAY
 *
 */
public class Address {
	private Long id;
	private String street;
	private String postCode;
	private Apartment apartment;


	/**
	 * @param id
	 * @param street
	 * @param postCode
	 * @param apartment
	 */
	public Address(Long id, String street, String postCode, Apartment apartment) {
		super();
		this.id = id;
		this.street = street;
		this.postCode = postCode;
		this.apartment = apartment;
	}
	/**
	 * @param street
	 * @param postCode
	 * @param apartment
	 */
	public Address(String street, String postCode, Apartment apartment) {
		super();
		this.street = street;
		this.postCode = postCode;
		this.apartment = apartment;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Apartment getApartment() {
		return apartment;
	}
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
	public Address get() {
		return this;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
