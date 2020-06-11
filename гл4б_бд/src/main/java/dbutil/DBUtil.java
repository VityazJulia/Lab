package dbutil;

import connector.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtil {
    private DBConnector dbConnector;
    private Connection connection;

    public DBUtil() {
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

    public String getTable() {
        String S[] = new String[50];
        String S1 = null;

        String Query = "SELECT * FROM business.ingredients";
        ResultSet resultSet = this.getQueryResultAsResultSet(Query);
        int index = 0;
        StringBuilder s = new StringBuilder();

        try {
            while (resultSet.next()) {
                s.append(resultSet.getString("NAME")+", calories: "+resultSet.getDouble("CALORIES")+", gramms: "+
                        resultSet.getDouble("WEIGHT")+"\n");
                S[index] = s.toString();
                index++;
            }
            S1 = S[index-1];
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return S1;
    }

    public String getTableSorted() {
        String S[] = new String[50];
        String S1 = null;

        String Query = "SELECT * FROM business.ingredients ORDER BY CALORIES";
        ResultSet resultSet = this.getQueryResultAsResultSet(Query);
        int index = 0;
        StringBuilder s = new StringBuilder();

        try {
            while (resultSet.next()) {
                s.append(resultSet.getString("NAME")+", calories: "+resultSet.getDouble("CALORIES")+", gramms: "+
                        resultSet.getDouble("WEIGHT")+"\n");
                S[index] = s.toString();
                index++;
            }
            S1 = S[index-1];
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return S1;
    }

    public String getCaloriesRange(double lower, double upper) {
        String S[] = new String[50];
        String S1 = null;

        String Query = "SELECT * FROM business.ingredients WHERE CALORIES>= "+lower+" AND CALORIES <= "+upper;
        ResultSet resultSet = this.getQueryResultAsResultSet(Query);
        int index = 0;
        StringBuilder s = new StringBuilder();

        try {
            while (resultSet.next()) {
                s.append(resultSet.getString("NAME")+", calories: "+resultSet.getDouble("CALORIES")+", gramms: "+
                        resultSet.getDouble("WEIGHT")+"\n");
                S[index] = s.toString();
                index++;
            }
            S1 = S[index - 1];
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return S1;
    }






}
