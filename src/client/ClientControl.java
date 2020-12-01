/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.*;
import java.io.*;
import java.util.Random;

/**
 *
 * @author TrungNguyen
 */
public class ClientControl {

    private int serverPort = 5555;
    private int clientPort = setport();
    private String serverHost = "localhost";
    private DatagramSocket myClient;
    private DatagramPacket dpsend, dpreceive;
    static AES_Encryption aes = new AES_Encryption();
    static RSA_Encryption rsa = new RSA_Encryption();
    String keyClient = taoKey();
    
    

    public ClientControl()   {
            
    }

    public void open() {
        try {
            
            
                myClient = new DatagramSocket(clientPort);


                String key = rsa.Encrpytion(keyClient);
                System.out.println("key: "+key);
                byte[] data = key.getBytes();
                InetAddress IPAddress = InetAddress.getByName(serverHost);
                dpsend = new DatagramPacket(data, data.length, IPAddress, serverPort);

                myClient.send(dpsend);
                
           
            
            
           
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            myClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendData(String o) {
        try {
            o = aes.encrypt(o, keyClient); 
            System.out.println("sendData: "+o);
            byte[] data;
            data = o.getBytes();
            InetAddress IPAddress = InetAddress.getByName(serverHost);
            dpsend = new DatagramPacket(data, data.length, IPAddress, serverPort);
            myClient.send(dpsend);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String receiveData() {
       String o = null;
        try {
                         dpreceive = new DatagramPacket(new byte[10000], 10000);
                        myClient.receive(dpreceive);
                        o = new String(dpreceive.getData(), 0, dpreceive.getLength());
                        
                        o = aes.decrypt(o, keyClient);
                        System.out.println("receiveData: "+o);
           
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
    public static String taoKey()
    {
        Random ran = new Random();
        int top = 6;
        char data = ' ';
        String dat = "";

        for (int i=0; i<=top; i++) {
          data = (char)(ran.nextInt(25)+97);
          dat = data + dat;
        }
        return dat;
    }
    public static int setport()
    {
        Random ran = new Random();

        int value = ran.nextInt((10000 - 1001) - 1);
        return value;
    }
}
