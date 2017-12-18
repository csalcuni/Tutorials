package it.scp.cetriolo;

import java.io.*;
import java.util.Date;

public class FileChecker {

    public void check(File originale) {

        Date inizio = new Date();

        OracleJDBC oracleJDBC = new OracleJDBC();

        try {
            File outputFile = new File("/tmp/output.txt");
            if (outputFile.exists())
                outputFile.delete();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));



            oracleJDBC.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(originale));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String campo1, campo2;
                campo1 = line.substring(0, 12);
                campo2 = line.substring(24, 71);
                if (oracleJDBC.performOperation(campo1, campo2)) {
                    bufferedWriter.write(campo1 + " --- " + campo2);
                    bufferedWriter.newLine();
                }
            }
            bufferedReader.close();
            bufferedWriter.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            oracleJDBC.closeConnection();
            Date fine = new Date();
            System.out.println("Secondi Trascorsi = " + ((fine.getTime() - inizio.getTime()) / 1000));
        }
    }

    public static void main(String[] args) {

        FileChecker fileChecker = new FileChecker();
        File originale = new File("/tmp/originale.txt");

        fileChecker.check(originale);

    }


}
