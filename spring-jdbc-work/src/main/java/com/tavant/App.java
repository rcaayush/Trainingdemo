package com.tavant;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.tavant.dao.DatabaseOperations;
import com.tavant.user.User;



public class App 
{
    public static void main( String[] args )
    {

    	
//        Load the context
    	ClassPathXmlApplicationContext theContext = new ClassPathXmlApplicationContext("config.xml");
    	
//    	Get a reference to the bean
    	DatabaseOperations theOperate = theContext.getBean("databaseOperations", DatabaseOperations.class);
    	//NamedParameterJdbcTemplate ref=new theContext.getBean();
//    	Call the method
//    	System.out.println("Numbers of users registered with us : " + theOperate.getCountOfUsers());
    	
    	Scanner theScan = new Scanner(System.in);
    	
    	while(true)
    	{
    		 System.out.println("Enter 1 for Adding user ");

    		    System.out.println("Enter 2 for Showing Balance ");

    		    System.out.println("Enter 3 for Deposit ");

    		    System.out.println("Enter 4 for Withdraw ");

    		    System.out.println("Enter 5 for Fund Transfer ");

    		    System.out.println("Enter 6 for Transaction History ");
    		    
    		    System.out.println("Enter 7 To delete a Row");
    		    
    		    System.out.println("Enter 8 To Display all Users");

    		    
    		    int choice;
    		    choice=theScan.nextInt();
    		    switch(choice) {
    		    
    		    case 1:{
    		      	System.out.println("Enter then name");
    		    	String userName = theScan.next();
    		    	System.out.println("Enter the balance");
    		    	int bal = theScan.nextInt();
    		    	System.out.println("User added "+theOperate.createUser(userName,bal));
    		    	break;
    		    }
    		    case 2:{
    		    	System.out.println("Enter then name");
    		    	String userName = theScan.next();
    		    	System.out.println("Balance for " + userName + " : " + theOperate.showbalance(userName));
    		    	break;
    		    }
    		    
    		    case 3:{
    		      	System.out.println("Enter then name");
    		    	String userName = theScan.next();
    		    	System.out.println("Enter the balance");
    		    	int bal = theScan.nextInt();
    		    	
    		    	System.out.println(theOperate.Deposit(userName, bal));
    		    
    		    break;
    		    }
    		    
    		    case 4:{
    		    	
    		    	System.out.println("Enter then name");
    		    	String userName = theScan.next();
    		    	System.out.println("Enter the balance");
    		    	int bal = theScan.nextInt();
    		    	
    		    	System.out.println(theOperate.Withdraw(userName, bal));
    		    	
    		    	break;
    		    }
    		    case 5:{
    		    	System.out.println("Enter the Name from whom withdraw is to be made ");
    		    	String name1=theScan.next();
    		    	System.out.println("Enter the Name from whom Deposit is to be made ");
    		    	String name2=theScan.next();
    		    	System.out.println("Enter the amount to be transffered ");
    		    	int bal=theScan.nextInt();
    		    	System.out.println(theOperate.FundTransfer(name1,name2,bal));
    		    	System.out.println("Fund Transffered from "+name1+" to "+name2+" of "+ bal+" INR ");
    		    	break;
    		    }
    		    
    		    case 6:{
    		    	theOperate.TransactionHistory();
    		    }
    		    
    		    case 7:{
    		    	System.out.println("Enter the Name from whom withdraw is to be made ");
    		    	String name1=theScan.next();
    		    	System.out.println(theOperate.deleteRow(name1));

    		    }
    		    case 8:{
    		    	System.out.println("List of All Users ");
    		    	//System.out.println(theOperate.getAllUserDetails());
    		    	for(User u:theOperate.getAllUserDetails()) {
    		    		System.out.println(u.getName());
    		    	}
    		    	
    		    }
    		    
    		    }
    	}
  
    	
    	
    	//System.out.println("User added "+theOperate.createUser(userName,bal));
    	
   // 	System.out.println(theOperate.Deposit(userName, bal));
   // 	System.out.println("UserSalary for " + userName + " : " + theOperate.getSalaryByUserName(userName));

    	
//    	Get a reference to the bean
//    	UserService theService = theContext.getBean("userService", UserService.class);
    	
//    	Call method/s on the bean
//    	theService.connectToDb();
//    	System.out.println("Currently we have " + theService.getCountOfUsers() + " number of users registered...");
    }
}
