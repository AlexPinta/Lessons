package ua.ap.Homework5;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 17.05.15
 * Time: 23:27
 * @version: 1.0
 */
public class Main {
    public static void main(String args[]) {
        Students[] arrStudents = new Students[3];
        Students[] arrInputStudents = new Students[3];

        arrStudents[0] = new Students("Alex", "Ivanov", 'm', 20, 3);
        arrStudents[1] = new Students("Natasha", "Ivanova", 'f', 18, 1);
        arrStudents[2] = new Students("Igor", "Kulikov", 'm', 21, 4);
        FileOutputStream outputFile = null;

        File locFile = new File("output.dat");
        if (locFile.exists() == false) {
            try {
                locFile.createNewFile();
            } catch (IOException ioe) {
                System.out.println("Error in create file operation");
                return;
            }

        }

        try {
            outputFile = new FileOutputStream(locFile);
        } catch (FileNotFoundException fe) {
            System.out.println("Error in generation output steam");
            return;
        }

        try {
            ObjectOutputStream locObjectOutputStream = new ObjectOutputStream(outputFile);
            locObjectOutputStream.writeInt(arrStudents.length);
            for (Students arrElem : arrStudents) {
                locObjectOutputStream.writeObject(arrElem);
            }
            locObjectOutputStream.flush();
            locObjectOutputStream.close();
        } catch (IOException ioe) {
            System.out.println("Can't write file.");
            return;
        }


        FileInputStream locFileInputStream = null;
        try {
            locFileInputStream = new FileInputStream(locFile);
        } catch (FileNotFoundException fe) {
            System.out.println("Error in generation output steam");
            return;
        }

        try {
            ObjectInputStream locObjectInputStream = new ObjectInputStream(locFileInputStream);
            try {
                int dimension = locObjectInputStream.readInt();
                for (int i = 0; i < dimension; i++) {
                    arrInputStudents[i] = (Students) locObjectInputStream.readObject();
                }
            } catch (ClassNotFoundException ce) {
                System.out.println("Incorrect class.");
                return;
            }
            locObjectInputStream.close();
        } catch (IOException ioe) {

        }
    }
}