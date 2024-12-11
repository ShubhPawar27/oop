import java.io.*;
import java.util.Scanner;

public class student_dtabase {
    private static final String FILE_NAME = "student_database.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Database Management:");
            System.out.println("1. Create Database");
            System.out.println("2. Display Database");
            System.out.println("3. Delete Record");
            System.out.println("4. Update Record");
            System.out.println("5. Search Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createDatabase(scanner);
                    break;
                case 2:
                    displayDatabase();
                    break;
                case 3:
                    deleteRecord(scanner);
                    break;
                case 4:
                    updateRecord(scanner);
                    break;
                case 5:
                    searchRecord(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void createDatabase(Scanner scanner) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            System.out.print("Enter Student ID: ");
            String id = scanner.next();
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Roll No: ");
            String rollNo = scanner.next();
            System.out.print("Enter Class: ");
            String studentClass = scanner.next();
            System.out.print("Enter Marks: ");
            String marks = scanner.next();
            System.out.print("Enter Address: ");
            scanner.nextLine(); // consume leftover newline
            String address = scanner.nextLine();

            writer.write(id + "," + name + "," + rollNo + "," + studentClass + "," + marks + "," + address + "\n");
            System.out.println("Record added successfully!");
        } catch (IOException e) {
            System.out.println("Error while writing to the database file.");
        }
    }

    private static void displayDatabase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nStudent Records:");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("ID: " + data[0] + ", Name: " + data[1] + ", Roll No: " + data[2] + ", Class: " + data[3] + ", Marks: " + data[4] + ", Address: " + data[5]);
            }
        } catch (IOException e) {
            System.out.println("Error while reading the database file.");
        }
    }

    private static void deleteRecord(Scanner scanner) {
        System.out.print("Enter the Student ID to delete: ");
        String idToDelete = scanner.next();
        File tempFile = new File("temp.txt");
        boolean deleted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
             FileWriter writer = new FileWriter(tempFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.split(",")[0].equals(idToDelete)) {
                    writer.write(line + "\n");
                } else {
                    deleted = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error while processing the file.");
        }

        if (tempFile.renameTo(new File(FILE_NAME)) && deleted) {
            System.out.println("Record deleted successfully!");
        } else {
            System.out.println("Record not found.");
        }
    }

    private static void updateRecord(Scanner scanner) {
        System.out.print("Enter the Student ID to update: ");
        String idToUpdate = scanner.next();
        File tempFile = new File("temp.txt");
        boolean updated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
             FileWriter writer = new FileWriter(tempFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(idToUpdate)) {
                    System.out.println("Enter new details:");
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Roll No: ");
                    String rollNo = scanner.next();
                    System.out.print("Enter Class: ");
                    String studentClass = scanner.next();
                    System.out.print("Enter Marks: ");
                    String marks = scanner.next();
                    System.out.print("Enter Address: ");
                    scanner.nextLine(); // consume leftover newline
                    String address = scanner.nextLine();

                    writer.write(idToUpdate + "," + name + "," + rollNo + "," + studentClass + "," + marks + "," + address + "\n");
                    updated = true;
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error while processing the file.");
        }

        if (tempFile.renameTo(new File(FILE_NAME)) && updated) {
            System.out.println("Record updated successfully!");
        } else {
            System.out.println("Record not found.");
        }
    }

    private static void searchRecord(Scanner scanner) {
        System.out.print("Enter the Student ID to search: ");
        String idToSearch = scanner.next();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(idToSearch)) {
                    System.out.println("Record Found: ID: " + data[0] + ", Name: " + data[1] + ", Roll No: " + data[2] + ", Class: " + data[3] + ", Marks: " + data[4] + ", Address: " + data[5]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Record not found.");
            }
        } catch (IOException e) {
            System.out.println("Error while reading the database file.");
        }
    }
}

