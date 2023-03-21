package jdbstests;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String dbUrl="jdbc:oracle:thin:@34.234.234.150:1521:XE";

        String dbUsername="hr";
        String dbPassword="hr";

        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        Statement statement =connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM regions");




/*
        //once you set up connection default pointer looks for 0
        //1.next() ---> move pointer to first row (row'da ilerletir)
        resultSet.next();
        //row'u next() ile ilerletebiliriz. column ilerletmek için ise 2 seçenek var, ya column ismi ya da column indexi)
        //2.getting information with column name
        System.out.println(resultSet.getString("region_name"));     //Europe
        //2.getting information(2ndWay) with column index(starts 1)
        System.out.println(resultSet.getString(2));            //Europe
        //you will choose (getString,getInt) this data type according to what you gonna display from database
*/



        System.out.println("-----------------");
        //print these;
        /*1 - Europe
          2 - Americas
          ....
         */

/*
        System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));
        //move to second row
        resultSet.next();
        System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));
        //move to third row
        resultSet.next();
        System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));
*/

        System.out.println("-------------");

        //for this repeating, use loops
        while (resultSet.next()){     //whenever no more row avaliable,it will stop
            System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));

        }
        //by the help of while loop we can get that -> row number is dynamic



        //close connection
        resultSet.close();
        statement.close();
        connection.close();


    }
}


/*
This 3 steps are important and all comes from import java.sql.*;
Connection (java.sql)—> Helps our java project connect to database
Statement —> Helps to write and execute SQL query
ResultSet —> A datastructure where we can store the data that came from database
 */





