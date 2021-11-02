package demo.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import demo.registration.model.Students;

public class StudentsDao 
{
public int registerStudent(Students students ) throws ClassNotFoundException
{
	String INSERT_USERS_SQL="insert into sys.students values(?,?,?,?,?,?)"  ;
	String url="jdbc:mysql://127.0.0.1:3306?user=root&password=root";
	int result=0;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=DriverManager.getConnection(url);
	PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL);
	preparedStatement.setInt(1, 1);
	preparedStatement.setString(2, students.getFirstName());
	preparedStatement.setString(3, students.getLastName());
	preparedStatement.setString(4, students.getContact());
	preparedStatement.setString(5, students.getUserName());
	preparedStatement.setString(6, students.getPassword());
	System.out.println(preparedStatement);
	result=preparedStatement.executeUpdate(); 
}
catch (Exception e) {
	
	e.printStackTrace();
}
return result;
}
}

/*String INSERT_USERS_SQL="insert into sys.student" +" (id,first_name,last_name,contact,username,password) " +
                         "(?,?,?,?,?,?);" ;*/