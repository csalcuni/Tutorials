package it.scp.cetriolo;

import java.sql.*;

public class OracleJDBC {

    private Connection connection;

    public void openConnection() {
        System.out.println("Apro la connessione");
        try {
            if ((connection == null) || (connection.isClosed())) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection("jdbc:oracle:thin:@10.200.226.70:1521:QZS1", "QPAT", "QPAT");
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class oracle.jdbc.driver.OracleDriver NOT FOUND");
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            System.out.println("SQL Exception obtaining connection");
            sqle.printStackTrace();
        }
    }

    public void closeConnection() {
        System.out.println("Chiudo la connessione");
        try {
            if (!connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean performOperation(String campo1, String campo2) {
        try {
            System.out.println("Connessione Aperta = " + !connection.isClosed());

            System.out.println("Eseguo query su " + campo1 + ", " + campo2);

//            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM EP.TTEP1TSS");
//
//            while (resultSet.next()) {
//                System.out.println("CAMPO = " + resultSet.getString("COD_SPZ_TIP_SED_ESA"));
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

}
