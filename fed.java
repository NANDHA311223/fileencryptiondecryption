package cognifyz;
import java.io.*;
import java.util.Scanner;
public class Lvl2Tsk3 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter 'E' for encryption or 'D' for decryption:");
	        char choice = scanner.nextLine().toUpperCase().charAt(0);

	        System.out.println("Enter the file name or path:");
	        String fileName = scanner.nextLine();

	        switch (choice) {
	            case 'E':
	                encryptFile(fileName);
	                break;
	            case 'D':
	                decryptFile(fileName);
	                break;
	            default:
	                System.out.println("Invalid choice.");
	        }

	        scanner.close();
	    }

	    private static void encryptFile(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
	             BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_" + fileName))) {

	            String line;
	            while ((line = reader.readLine()) != null) {
	                StringBuilder encryptedLine = new StringBuilder();
	                for (char c : line.toCharArray()) {
	                    encryptedLine.append((char) (c + 1)); // Caesar cipher encryption
	                }
	                writer.write(encryptedLine.toString());
	                writer.newLine();
	            }

	            System.out.println("Encryption successful. Encrypted file saved as 'encrypted_" + fileName + "'");
	        } catch (IOException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    private static void decryptFile(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
	             BufferedWriter writer = new BufferedWriter(new FileWriter("decrypted_" + fileName))) {

	            String line;
	            while ((line = reader.readLine()) != null) {
	                StringBuilder decryptedLine = new StringBuilder();
	                for (char c : line.toCharArray()) {
	                    decryptedLine.append((char) (c - 1)); // Caesar cipher decryption
	                }
	                writer.write(decryptedLine.toString());
	                writer.newLine();
	            }

	            System.out.println("Decryption successful. Decrypted file saved as 'decrypted_" + fileName + "'");
	        } catch (IOException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}