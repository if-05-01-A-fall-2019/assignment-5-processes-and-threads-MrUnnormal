/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javashell;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Jan Kaufmann 3AHIF
 */
public class JavaShell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true) {
            System.out.print("> ");
            Scanner input =  new Scanner(System.in);
            String userInput = input.nextLine();
            String[] commands = userInput.trim().split("&");
            for(int i = 0; i < commands.length; i++) {
                if(commands[i].equals("exit") || commands[i].equals("quit")) {
                    return;
                }
                try {
                    executeCommand(commands[i]);
                }
                catch (Exception e) {
                    System.out.println("An Error occured: " + e.getMessage());
                }
            }
        }
    }
    
    public static void executeCommand(String command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        InputStream input = process.getInputStream();
        int i = input.read();
        while(i != -1) {
            System.out.print((char)i);
            i = input.read();
        }
    }
    
}
