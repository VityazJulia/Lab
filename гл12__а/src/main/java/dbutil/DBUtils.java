package dbutil;


import entity.Person;
import entity.Letter;
import connector.DBConnector;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class DBUtils {
    private DBConnector dbConnector;
    private Connection connection;

    public DBUtils() {
        this.dbConnector = new DBConnector();
        this.connection = this.dbConnector.getConnection();
    }



    public String ArrayListToSQLList(ArrayList<Integer> integers) {
        StringBuilder sqlListBuilder = new StringBuilder().append("(");

        for(int i = 0; i < integers.size(); i++) {
            if (i == integers.size() - 1) {
                sqlListBuilder.append(integers.get(i));
            }
            else {
                sqlListBuilder.append(integers.get(i)).append(", ");
            }
        }

        return sqlListBuilder.append(")").toString();
    }

    public ResultSet getQueryResultAsResultSet(String query) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void executeInsertOrUpdateOrDeleteQuery(String query) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getTableLength(String table) {
        int length = 0;

        String lengthQuery = "SELECT * FROM " + table;
        ResultSet resultSet = this.getQueryResultAsResultSet(lengthQuery);

        try {
            while (resultSet.next()) {
                length++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return length;
    }


    public String getMinLetterLength() throws SQLException {
        String query =
                "SELECT SENDER,LENGTH(TEXT) AS L FROM business.letters_ ";
        ResultSet resultSet = this.getQueryResultAsResultSet(query);

        String s = null;
        try {
            resultSet.next();
            int len = resultSet.getInt("L");
            s = resultSet.getString("SENDER");
            while(resultSet.next()) {
                if(resultSet.getInt("L") < len) {len = resultSet.getInt("L");
                s = resultSet.getString("SENDER");}
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    public int getNumberOfSentLetters(String person){
        String query1 = "SELECT COUNT(ID) FROM business.letters_ WHERE SENDER = '"+person+"'";
        ResultSet resultSet1 = this.getQueryResultAsResultSet(query1);
        int S = 0;


        try {
           resultSet1.next();
                S= resultSet1.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return S;
    }

    public int getNumberOfRecievedLetters(String person){
        String query1 = "SELECT COUNT(ID) FROM business.letters_ WHERE RECIPIENT = '"+person+"'";
        ResultSet resultSet1 = this.getQueryResultAsResultSet(query1);
        int S = 0;


        try {
            resultSet1.next();
            S = resultSet1.getInt(1);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return S;
    }


    public String getUserInformation(){
        String Query ="SELECT * FROM business.people_";
        ResultSet resultSet = this.getQueryResultAsResultSet(Query);
        String[] S = new String[50];
        String u = null;
        int index = 0;
        int k = 0;
        StringBuilder s = new StringBuilder();
        try {

            while (resultSet.next()) {
                int SENT = getNumberOfSentLetters(resultSet.getString("NAME"));
                int RECIEVED = getNumberOfRecievedLetters(resultSet.getString("NAME"));
                s.append(resultSet.getString("NAME")+" "+resultSet.getDate("BIRTH_DATE").toString()+" recieved: "+
                        RECIEVED+" sent: "+
                        SENT+"\n");
                S[index] = s.toString();
                index++;

            }
            u = S[index-1];
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return u;
    }


    public String[] getUserWithGivenLetterTopic(String topic){
        String Query = "SELECT RECIPIENT FROM  business.letters_ WHERE TOPIC = '"+topic+"'";
        ResultSet resultSet = this.getQueryResultAsResultSet(Query);
        String[] P = new String[50];
        int index = 0;
        try {

            while (resultSet.next()) {
                P[index] = resultSet.getString("RECIPIENT");

                index++;
            }


        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return P;
    }

    public String[] getUserWithNotGivenLetterTopic(String topic){
        String Query = "SELECT DISTINCT RECIPIENT FROM business.letters_ WHERE TOPIC NOT LIKE '"+topic+"'"+
                " AND RECIPIENT NOT IN (SELECT RECIPIENT FROM business.letters_ WHERE TOPIC = '"+topic+"')";
        ResultSet resultSet = this.getQueryResultAsResultSet(Query);

        String[] P = new String[50];
        int index = 0;
        try {

            while (resultSet.next()) {
                P[index] = resultSet.getString("RECIPIENT");
                index++;

            }


        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return P;
    }


    public void SendLetterToAll(String person, String topic) {
        try{
            int newLNKId = this.getTableLength("business.letters_") + 1;
            int peoplenum = this.getTableLength("business.people_");
            String query ="SELECT NAME FROM business.people_";
            String[] s = new String[50];
            int index = 0;
            ResultSet resultset = this.getQueryResultAsResultSet(query);

            while (resultset.next()) {
                s[index] = resultset.getString("NAME");
                index++;
            }



            String Query = "SELECT * FROM business.letters_ WHERE SENDER = '"+person+"' AND TOPIC = '"+topic+ "'";
            ResultSet resultSet = this.getQueryResultAsResultSet(Query);

            Date datenow = new Date();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");


            String text = "there were a few letters from me with such topic and I could not decide which one to send, thats why fuck off";
            if (resultSet.next())  text = resultSet.getString("TEXT");

            for(int i=0; i<peoplenum; i++){
                String insertLNKQuery = new StringBuilder("INSERT INTO business.letters_ VALUES(")
                        .append(newLNKId)
                        .append(", '")
                        .append(person)
                        .append("', '")
                        .append(s[i])
                        .append("', '")
                        .append(topic).append("', '")
                        .append(text).append("', '")
                        .append(date.format(datenow).toString())
                        .append("')").toString();
                this.executeInsertOrUpdateOrDeleteQuery(insertLNKQuery);
                newLNKId++;} }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}