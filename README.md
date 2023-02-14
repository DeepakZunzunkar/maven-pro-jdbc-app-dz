#### maven-pro-jdbc-app-dz
 > console based java application where basic jdbc topics are covered like statement, prepared statement, callable statement


```
 There are 6 steps to connect any java application with the database using JDBC

- 1.Load the JDBC driver class or register the JDBC driver.
    class.forName("fully qualified driver class name")
    EX: Class.forName("com.mysql.jdbc.Driver")
    
- 2.Establish the connection means provide the connection between java application and database
    Connection con =  DriverManager.getConnection(url,username,password);
   EX: Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz","root","root");
    
- 3.Create a statement or PreparedStatement or callable statement
     A.  Statement stmt=con.createStatement();
                     ResultSet rs=st.executeQuery(query); 
                     int status= stmt.executeUpdate(query);
                     boolean status= = stmt.execute(query);
                     
     B. PreparedStatement ps=con.prepareStatement(query with place-resolution operator '?' ); 
                         then set value in replacement operator and then execute.
      
- 4.Execute the sql commands on database and get the result
      public int executeUpdate(String sql): Used for non-select operations and Used to execute specified query,it may be create, drop, insert, update, delete etc.
			public ResultSet executeQuery(String sql): Used for select operation and it is Used to execute SELECT query. It returns the object of ResultSet.
			public boolean execute(String sql) : Used for both select or non-select operation and it is Used to execute queries that may return multiple results.
      public int[] executeBatch()  : Used to execute batch of commands.
      
- 5.Print the result



- 6.Close the connection
      By closing connection object statement and ResultSet will be closed automatically. 
      The close() method of Connection interface is used to close the connection

```

###### JDBC Driver
```
JDBC API contains a set of classes and Interfaces where classes definition is provided by Sun Micro System and 
Interfaces Implementation are not provided(interface implementing classes).
For interface Implementation classes will be provided by vendors like oracle,MySQl.., these set of classes are 
called Jdbc Driver and A Driver API contains set of classes among these classes one class is driver class.
Driver class is a mediator class between a java application and a database

```

###### Draw Backs of JDBC

- 	for enterprice application jdbc is not suitable,because jdbc query are database centric query 
  	in future if we want to move one database to another database we have to change that query style.
  	so in jdbc ,sql operation are database centric operation so even java is platform indipendant 
	but if you write java DAO class by using jdbc then ur class will become database dependant
-	In JDBC, if we open a database connection we need to write in try, and 
	if any exceptions occurred catch block will take care about it, and finally used to close the connections.
-	here as a programmer we must close the connection, or we may get a chance to get out of connections message…!
-	Actually if we didn’t close the connection in the finally block, then jdbc doesn’t responsible to close that connection.
-	In JDBC we need to write Sql commands in various places, after the program has created if the table structure is modified 
	then the JDBC program doesn’t work, again we need to modify and compile and re-deploy required, which is tedious.
-	JDBC used to generate database related error codes if an exception will occurs, but java programmers are unknown about this error codes right.
-	In the Enterprise applications, the data flow with in an application from class to class will be in the form of objects,
	but while storing data finally in a database using JDBC then that object will be converted into text.  
	Because JDBC doesn’t transfer objects directly.
-	here Whateever data we get in Object that we have to map mannualy with the table column in query and we can not directly save object in database and if object 	       is too complex then ,it is tidious job to do mapping mannualy .

>In order to overcome above problems,  Hibernate came into picture..!
-	In Hibernate , we don't need to do mapping of Object while saving the Object hibernate will do it internally for us and we just need to pass object even if it 	       is too complex object hibernate map it corretly .
-	there are lots of futures in hibernate , here it treat java class as Table and class Object as record and also track Object state and synk with table data .
	it basically try to reduce repeateting code and as compared to JDBC hibernate is faster .
