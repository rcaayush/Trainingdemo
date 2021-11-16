package demoProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Project1 {
	

	
		final static String URLTOCONNECT = "jdbc:mysql://localhost:3306/wallet";
		
		final static String USERNAME = "root";
		
		final static String USERPASSWORD = "rishu12@";
		
		static Connection dbCon;
		
		static Statement theStatement;
		
		static PreparedStatement thePreparedStatement;
		
		static ResultSet theResultSet;
		
		static ArrayList<String> list=new ArrayList<String>();
	
		
		
		
	    public static void main( String[] args ) throws ClassNotFoundException, SQLException
	    {
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				dbCon = DriverManager.getConnection(URLTOCONNECT, USERNAME, USERPASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	    	Scanner sc=new Scanner(System.in);
	    	
	    	while(true) {
	    		System.out.println("Enter 1 for Adding user ");
	    		System.out.println("Enter 2 for Showing Balance ");
	    		System.out.println("Enter 3 for Deposit ");
	    		System.out.println("Enter 4 for Withdraw ");
	    		System.out.println("Enter 5 for Fund Transfer ");
	    		System.out.println("Enter 6 for Transaction History ");
	    		
	    		int choice;
	    		choice=sc.nextInt();
	    		
	    		switch(choice) {
	    		
	    		case 1:
	    			
	    		{
	    			String name;
	    			name=sc.next();
	    			Date date = new Date();
	    			addUser(name,date);
	    		
	    		break;
	    		}
	    		
	    		case 2:{
	    			
	    			String name;
	    			name=sc.next();
	    			System.out.println("Details is as follows");
	    			String qrey;
	    			qrey = "select * from users where Name='"+name+"'";
	    			
	    			thePreparedStatement=dbCon.prepareStatement(qrey);
	    			theResultSet = thePreparedStatement.executeQuery();
	    			   while (theResultSet.next()) {
	    				   
	    	                
	    	                String name1 = theResultSet.getString("Name");
	    	                String bal = theResultSet.getString("balance");
	    	                
	    	            	Date date = new Date();
	    	            	list.add(name1 + "'s balance is : " +
                                    bal+" "+date.toString());
	    	            	System.out.println(name1 + "'s balance is : " +
                                    bal);
	    	            }
	    			
	    			break;
	    		}
	    		
	    		case 3:
	    		{
	    			String name;
	    			System.out.println("Enter name to whose deposit is to be made");
	    			name=sc.next();
	    			System.out.println("Enter amount to be deposited");
	    			int sum=sc.nextInt();
	    			String qrey;
	    			qrey = "select * from users where Name='"+name+"'";
	    			Statement st;
	    			Connection con=DriverManager.getConnection(URLTOCONNECT, USERNAME, USERPASSWORD);
	    			st=con.createStatement();
	    			theResultSet = st.executeQuery(qrey);

	    		int n,bal = 1;
	    			   while (theResultSet.next()) {
	    	                 bal = theResultSet.getInt("balance");
	    			   }
	    			   
	    
	    	                 String qry2="update users set balance=balance+'"+sum+" ' where name='"+name+"'";
	    	                 Statement s;
	    	                 s=con.createStatement();
	    	                 s.executeUpdate(qry2);
	    	                 System.out.println("Amount Deposited to "+name+" of "+sum);
	    	                 Date date=new Date();
	    	                 list.add("Amount Deposited to "+name+" of "+sum+" "+date.toString());
	   
	    	             	break;
	    	            }
	    			  
	    			
	    			
	    		
	    		
	    		case 4:
	    		{String name;
    			System.out.println("Enter name to whose withdraw is to be made");
    			name=sc.next();
    			System.out.println("Enter amount to be withdrawn");
    			int sum=sc.nextInt();
    			String qrey;
    			qrey = "select * from users where Name='"+name+"'";
    			Statement st;
    			Connection con=DriverManager.getConnection(URLTOCONNECT, USERNAME, USERPASSWORD);
    			st=con.createStatement();
    			theResultSet = st.executeQuery(qrey);

    		int n,bal = 1;
    			   while (theResultSet.next()) {
    	                 bal = theResultSet.getInt("balance");
    			   }
    			   
    	                 String qry2="update users set balance=balance-'"+sum+" ' where name='"+name+"'";
    	                 Statement s;
    	                 s=con.createStatement();
    	                 s.executeUpdate(qry2);
    	                 
    	                 System.out.println("Amount Withdrawn from "+name+" of "+sum);
    	                 Date date=new Date();
    	                 list.add("Amount Withdrawn to "+name+" of "+sum+" "+date.toString());
    	    
    	                 break;
    	            }
	    		case 5:
	    		{
	    			String name,name2;
	    			System.out.println("Enter name to whose withdraw is to be made");
	    			name=sc.next();
	    			System.out.println("Enter name to whose deposit is to be made");
	    			name2=sc.next();
	    			System.out.println("Enter amount to be withdrawn");
	    			int sum=sc.nextInt();
	    			String qrey;
	    			qrey = "select * from users where Name='"+name+"'";
	    			Statement st;
	    			Connection con=DriverManager.getConnection(URLTOCONNECT, USERNAME, USERPASSWORD);
	    			st=con.createStatement();
	    			theResultSet = st.executeQuery(qrey);

	    		int n,bal = 1;
	    			   while (theResultSet.next()) {
	    	                 bal = theResultSet.getInt("balance");
	    			   }
	    			   
	    		
	    	                 String qry2="update users set balance=balance-'"+sum+" ' where name='"+name+"'";
	    	                 Statement s;
	    	                 s=con.createStatement();
	    	                 s.executeUpdate(qry2);
	    	        
	    	                 
	    	                 
	    	                 String qreys;
	    		    			qreys = "select * from users where Name='"+name2+"'";
	    		    			Statement sts;
	    		    			Connection conn=DriverManager.getConnection(URLTOCONNECT, USERNAME, USERPASSWORD);
	    		    			sts=conn.createStatement();
	    		    			ResultSet e2;
	    		    			e2 = st.executeQuery(qreys);

	    		    		int ns,bals = 1;
	    		    			   while (e2.next()) {
	    		    	                 bals = e2.getInt("balance");
	    		    			   }
	    		    			   
	    		    	                 String qry3="update users set balance=balance+'"+sum+" ' where name='"+name2+"'";
	    		    	                 Statement ss;
	    		    	                 ss=conn.createStatement();
	    		    	                 ss.executeUpdate(qry3);
	    	                 System.out.println("Amount deposited to  "+name2+" from "+name);
	    	                 Date date=new Date();
	    	                 list.add("Amount Deposited to "+name2+" from "+name+" of "+sum+" "+date.toString());
	    	                 break;
	    		}
	    		
	    		case 6:{
	    			System.out.println("Transaction history is as follows :");
	    			for(String name:list) {
	    				System.out.println(name);
	    			}
	    		}
    		
    			
    			
    		}
	    		}
	    	}
	    

	    

		private static void addUser(String name,Date date) {
			String qry;
			PreparedStatement thePreparedStatement;
			qry = "insert into users(Account_number, Name, balance) values(?, ?, ?)";
			try {
	        
				thePreparedStatement = dbCon.prepareStatement(qry);
				Random rand = new Random();
				int upperbound=12;
				int random = rand.nextInt(upperbound);
			
				thePreparedStatement.setInt(1, random);
				thePreparedStatement.setString(2, name);
				thePreparedStatement.setInt(3, 0);
				

				if(thePreparedStatement.executeUpdate() > 0)
					System.out.println("User added successfully on "+date.toString());
			} catch (SQLException e) {
				System.out.println("Issues with PreparedStatement insert query : " + e.getMessage());
			}

		}
}
	  

	    	
	