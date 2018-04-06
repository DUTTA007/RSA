/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author TD
 */


import java.io.IOException;
import java.util.Scanner;



public class RSADEMO {
	

    public static void main(String[] args) throws IOException
    {
        RSA rsa = new RSA(300);//prime number bit length should be provided here!
        Scanner scanner=new Scanner(System.in);
        String teststring;
        
        rsa.printRSAValues();
        
        System.out.println("Enter the plain text:");
        teststring = scanner.nextLine();
        
        System.out.println("Encrypting String: " + teststring);
        
        // encrypt
        byte[] encrypted = rsa.encrypt(teststring.getBytes());
        System.out.println("Cipher Text: " + bytesString(encrypted));
        // decrypt
        byte[] decrypted = rsa.decrypt(encrypted);
        
        System.out.println("Decrypted String: " + new String(decrypted));
        
        scanner.close();
    }
 

	private static String bytesString(byte[] encrypted)
                
                
    {
        String test = "";
        for (byte b : encrypted)
        {
        	
            test += Byte.toString(b);
        }
        return test;
    }

}


