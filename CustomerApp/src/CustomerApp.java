import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class CustomerApp {
	static ArrayList<Customer> customerList = new ArrayList<Customer>();

	public static void main(String[] args) throws SQLException {
		// Init
		String lastName;
		Scanner input = new Scanner(System.in);
		int action;

		// System logic
		action = Validator.getInt(input, "Press (1) to search for a customer or press (2) to Edit a customer's address", 0,2);
		
		do
		{
			if (action==1)
			{
				lastName = Validator.getString(input, "Enter a customer last name.", false);
				customerList = CustomerDB.getCustomerList(lastName);
				if(!customerList.isEmpty())
					printCustomers();
				else
					System.out.println("No customers found.");
				action = Validator.getInt(input, "Press (1) to search for another customer or press (2) to Edit the customer's address or press (0) to quit.", 0,2);
			}
			else if(action == 2)
			{
				String fullname = Validator.getString(input, "Enter the customer's full name", true);
				String street = Validator.getString(input, "Enter the street address.", true);
				String city = Validator.getString(input, "Enter the city.", true);
				String state = Validator.getString(input, "Enter the state.", true);
				String zipcode = Validator.getString(input, "Enter the zip code.", true);
				CustomerDB.pushAddressUpdate(fullname, street, city, state, zipcode);
				
				action = Validator.getInt(input, "Press (1) to search for another customer or press (2) to Edit the customer's address or press (0) to quit.", 0,2);
			}
			
		}while(action != 0);
	}
	
	public static void printCustomers()
	{
		System.out.println("Customer(s): ");
		for(Customer cust:customerList)
		{
			System.out.println("Company ID: " + cust.getCompany_id());
			System.out.println(cust.getTitle() + " " + cust.getFullName());
			System.out.println(cust.getStreetAddress());
			System.out.println(cust.getCity() + ", " + cust.getState() + " " + cust.getZip());
			System.out.println(cust.getEmail());
			System.out.println(cust.getPosition() + " at " + cust.getCompany());
			System.out.println();
		}
	}
}
