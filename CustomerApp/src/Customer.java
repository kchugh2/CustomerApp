
public class Customer {
	private String title;
	private String fullName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String position;
	private String company;
	private String company_id;
	private boolean isEmpty;
	
	public Customer()
	{
		isEmpty = true;
	}
	
	public Customer(String title, String fullName, String streetAddress,
			String city, String state, String zip, String email,
			String position, String company, String company_id) {
		isEmpty = false;
		this.title = title;
		this.fullName = fullName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.position = position;
		this.company = company;
		this.company_id = company_id;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}

	public String getTitle() {
		return title;
	}
	public String getFullName() {
		return fullName;
	}
	
	public String getCompany_id() {
		return company_id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	public String getEmail() {
		return email;
	}
	public String getPosition() {
		return position;
	}
	public String getCompany() {
		return company;
	}
	
	
}
