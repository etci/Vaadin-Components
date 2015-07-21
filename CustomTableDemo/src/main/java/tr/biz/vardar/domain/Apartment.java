/**
 *
 */
package tr.biz.vardar.domain;

/**
 * @author KUTAY
 *
 */
public class Apartment {
	private Long id;
	private String apartmentNo;
	private String apartmentName;
	/**
	 * @param id
	 * @param apartmentNo
	 * @param apartmentName
	 */
	public Apartment(Long id, String apartmentNo, String apartmentName) {
		super();
		this.id = id;
		this.apartmentNo = apartmentNo;
		this.apartmentName = apartmentName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApartmentNo() {
		return apartmentNo;
	}
	public void setApartmentNo(String apartmentNo) {
		this.apartmentNo = apartmentNo;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public Apartment get() {
		return this;
	}
}
