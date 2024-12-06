/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, String[]> users = new HashMap<>(); // Stores users: username -> {firstName, lastName, password}

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            String menu = "Choose an option:\n1. Sign Up\n2. Log In\n3. Exit";
            int choice = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (choice) {
                case 1 -> signUp();
                case 2 -> logIn();
                case 3 -> {
                    running = false;
                    JOptionPane.showMessageDialog(null, "Goodbye! Thank you for using our portal.");
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    private static void signUp() {
        String username = JOptionPane.showInputDialog("Enter a Username:");
        while (username == null || username.trim().isEmpty() || users.containsKey(username)) {
            if (users.containsKey(username)) {
                username = JOptionPane.showInputDialog("Username already exists. Please choose a different one:");
            } else {
                username = JOptionPane.showInputDialog("Username cannot be empty. Please enter a valid Username:");
            }
        }

        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        while (firstName == null || firstName.trim().isEmpty()) {
            firstName = JOptionPane.showInputDialog("First Name cannot be empty. Please enter your First Name:");
        }

        String lastName = JOptionPane.showInputDialog("Enter Last Name:");
        while (lastName == null || lastName.trim().isEmpty()) {
            lastName = JOptionPane.showInputDialog("Last Name cannot be empty. Please enter your Last Name:");
        }

        String password = JOptionPane.showInputDialog("Enter a Password:");
        while (password == null || password.trim().isEmpty()) {
            password = JOptionPane.showInputDialog("Password cannot be empty. Please enter your Password:");
        }

        // Store user information
        users.put(username, new String[]{firstName, lastName, password});
        JOptionPane.showMessageDialog(null, "Sign-up successful! You can now log in.");
    }

    private static void logIn() {
        if (users.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No users found. Please sign up first.");
            return;
        }

        String username = JOptionPane.showInputDialog("Enter Username:");
        String password = JOptionPane.showInputDialog("Enter Password:");

        if (users.containsKey(username) && users.get(username)[2].equals(password)) {
            String firstName = users.get(username)[0];
            String lastName = users.get(username)[1];
            JOptionPane.showMessageDialog(null, "Welcome to our portal, " + firstName + " " + lastName + "!");
            runKanban(firstName, lastName);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
        }
    }

    private static void runKanban(String firstName, String lastName) {
        boolean running = true;

        while (running) {
            String menu = "Choose an option:\n1. Add Tasks\n2. Show Report (Coming Soon)\n3. Logout";
            int choice = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (choice) {
                case 1 -> JOptionPane.showMessageDialog(null, "Add Tasks functionality is under development.");
                case 2 -> JOptionPane.showMessageDialog(null, "Show Report functionality is coming soon.");
                case 3 -> {
                    running = false;
                    JOptionPane.showMessageDialog(null, "Goodbye, " + firstName + " " + lastName + "! See you next time.");
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }
}
