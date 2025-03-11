import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_Insert_2 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args)throws Exception {
		Connection con=DBConn.getConn();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter FName");
		String fname=sc.nextLine();
		System.out.println("Enter LName");
		String lname=sc.nextLine();
		System.out.println("Enter Email");
		String email=sc.nextLine();
		System.out.println("Enter Pass");
		String pass=sc.nextLine();
		System.out.println("Enter Mobile");
		String mobile=sc.nextLine();
		System.out.println("Enter Address");
		String address=sc.nextLine();
		
		Statement stmt=con.createStatement();
		// pk generation
		int regid=0;
		ResultSet rs=stmt.executeQuery("select max(regid) from register");
		if(rs.next()) {
			regid=rs.getInt(1);
		}
		regid++;
		
		
		//record insertion
		PreparedStatement pstmt=con.prepareStatement("INSERT INTO register VALUES (?,?,?,?,?,?,?)");
		pstmt.setInt(1, regid);
		pstmt.setString(2, fname);
		pstmt.setString(3, lname);
		pstmt.setString(4, email);
		pstmt.setString(5, pass);
		pstmt.setNString(6, mobile);
		pstmt.setString(7, address);
		int i=pstmt.executeUpdate();
		
		if(i==1) 
			System.out.println("record inserted");
		
		rs.close(); pstmt.close(); stmt.close(); con.close();
	}

}
