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

