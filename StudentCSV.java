import java.io.*;
import java.util.*;

public class StudentCSV {

    static final String FILE_NAME = "Students.csv";

    public static void main(String[] args) {

        try {
            createFileWithHeader();
            addInitialRows();
            addMoreStudents();
            updateMarks();
            calculatePercentage();
            deleteStudent(2); // delete student with ID = 2
            displayFile();

        } catch (IOException e) {
            System.out.println("⚠ IOException occurred: " + e.getMessage());
        }
    }

    // 🔹 Create file + header
    static void createFileWithHeader() throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME);
        fw.write("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage\n");
        fw.close();
        System.out.println("File created with header");
    }

    // 🔹 Add initial rows
    static void addInitialRows() throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME, true);

        fw.write("1,Rajat,AI,80,85,90,70,75,0\n");
        fw.write("2,Amit,CS,70,75,80,65,60,0\n");

        fw.close();
        System.out.println("Initial rows added");
    }

    // 🔹 Add 3 more rows (marks4 & marks5 = 0)
    static void addMoreStudents() throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME, true);

        fw.write("3,Riya,IT,88,77,66,0,0,0\n");
        fw.write("4,Karan,AI,90,85,80,0,0,0\n");
        fw.write("5,Neha,CS,60,70,75,0,0,0\n");

        fw.close();
        System.out.println("3 more students added");
    }

    // 🔹 Update marks4 and marks5
    static void updateMarks() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (!data[0].equals("studentId")) {
                // update marks4 & marks5 randomly
                data[6] = String.valueOf((int)(Math.random() * 100));
                data[7] = String.valueOf((int)(Math.random() * 100));
            }

            lines.add(String.join(",", data));
        }
        br.close();

        FileWriter fw = new FileWriter(FILE_NAME);
        for (String l : lines) {
            fw.write(l + "\n");
        }
        fw.close();

        System.out.println("Marks updated");
    }

    // 🔹 Calculate percentage
    static void calculatePercentage() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (!data[0].equals("studentId")) {
                int total = 0;
                for (int i = 3; i <= 7; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double percentage = total / 5.0;
                data[8] = String.format("%.2f", percentage);
            }

            lines.add(String.join(",", data));
        }
        br.close();

        FileWriter fw = new FileWriter(FILE_NAME);
        for (String l : lines) {
            fw.write(l + "\n");
        }
        fw.close();

        System.out.println("Percentage calculated and updated");
    }

    // 🔹 Delete a row by studentId
    static void deleteStudent(int id) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

        String line;
        while ((line = br.readLine()) != null) {
            if (!line.startsWith(id + ",")) {
                lines.add(line);
            }
        }
        br.close();

        FileWriter fw = new FileWriter(FILE_NAME);
        for (String l : lines) {
            fw.write(l + "\n");
        }
        fw.close();

        System.out.println("Deleted student with ID: " + id);
    }

    // 🔹 Display file
    static void displayFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

        System.out.println("\nFinal CSV Data:");
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}