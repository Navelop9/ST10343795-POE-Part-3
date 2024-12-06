/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javax.swing.JOptionPane;

public class Login {
    public static boolean login(String username, String password) {
        String correctUsername = "admin";
        String correctPassword = "password";

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            JOptionPane.showMessageDialog(null, "Login Successful!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid login. Try again.");
            return false;
        }
    }
}
