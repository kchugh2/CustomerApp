import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;



public class CustomerDB{
	
	public static ArrayList<Customer> getCustomerList(String lastName)
	{
		ArrayList<Customer> customerList = new ArrayList <Customer> ();
		
		try
		{
			//URL of Oracle database server
			String url = "jdbc:oracle:thin:system/password@localhost"; 

			//properties for creating connection to Oracle database
			Properties props = new Properties();
			props.setProperty("user", "testuserdb");
			props.setProperty("password", "password");

			//creating connection to Oracle database using JDBC
			Connection conn = DriverManager.getConnection(url,props);

			String sql = "select c.*, css.city , css.state from customers c, customer_city_state css where (lastname = '" + lastName + "') and (c.customer_id = css.customer_id)";
			//System.out.println(sql);
			//creating PreparedStatement object to execute query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			ResultSet result = preStatement.executeQuery();
			//result.beforeFirst();
			if (result.isBeforeFirst())
			{
				while(result.next())
				{
					/*
					    String title, String fullName, String streetAddress,
						String city, String state, String zip, String email,
						String position, String company)
					 */
					Customer tempCustomer = new Customer(result.getString("title"), result.getString("fullname"), result.getString("streetaddress"), result.getString("city"),
							result.getString("state"), result.getString("zipcode"), result.getString("emailaddress"), result.getString("position"), result.getString("company"),
							result.getString("company_id"));
					customerList.add(tempCustomer);
				}
				conn.close();
			}
			else
			{
				conn.close();
			}
		}catch (SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return customerList;
	}
	
	public static void pushAddressUpdate(String fullname, String street, String city, String state, String zipcode) throws SQLException{
		//URL of Oracle database server
        String url = "jdbc:oracle:thin:system/password@localhost";
        
        //properties for creating connection to Oracle database
        Properties props = new Properties();
        props.setProperty("user", "testuserdb");
        props.setProperty("password", "password");
        
        //creating connection to Oracle database using JDBC
        Connection conn = DriverManager.getConnection(url,props);
        
        String sql =("UPDATE customers SET streetaddress = '"+street+"',zipcode= '"+zipcode+"' where fullname = '"+fullname+"'");        
        PreparedStatement preStatement = conn.prepareStatement(sql);
        preStatement.executeQuery();
        conn.close();
        
      
        
        Connection conn2 = DriverManager.getConnection(url,props);
        String sql2 = ("UPDATE customer_city_state SET city = '"+city+"',state= '"+state+"' where full_name = '"+fullname+"'");
        PreparedStatement preStatement2 = conn2.prepareStatement(sql2);
        preStatement2.executeQuery();
        conn2.close();
        
       
        

       
        
       
	}
	
	
	
}	
	
	