import java.net.*;
import java.io.*;

import java.util.Scanner;

public class Client2 {
    public static void main(String[] args){
        try {
            Socket s = new Socket("localhost", 1234);

            InputStream is=s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            OutputStream os=s.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);

            Scanner clavier = new Scanner(System.in);
            System.out.println("Donner votre nom");

            String str=clavier.next();


            pw.println(str);

            String res = br.readLine();
            System.out.println("Res ="+res);


        } catch (Exception e){
            e.printStackTrace();
        }


    }

}