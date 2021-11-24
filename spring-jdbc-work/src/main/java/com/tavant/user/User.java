package  com.tavant.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class User {
String name;

public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public User(String name) {
	super();
	this.name = name;
}



public User(){}



@Override
public String toString() {
	return "User [name=" + name + "]";
}
}
