import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client3{
    public static void main(String[] args) {
        try {
            Scanner clavier = new Scanner(System.in);

            while (true) {
                // Établir une connexion avec le serveur
                Socket s = new Socket("localhost", 1234);

                // Flux d'entrée
                InputStream is = s.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                // Flux de sortie
                OutputStream os = s.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);

                // Demander le nom de l'utilisateur
                System.out.println("Donnez votre nom (ou 'exit' pour quitter) :");
                String str = clavier.next();

                // Quitter la boucle si l'utilisateur tape "exit"
                if (str.equalsIgnoreCase("exit")) {
                    break;
                }

                // Envoyer le nom au serveur
                pw.println(str);

                // Recevoir et afficher la réponse du serveur
                String res = br.readLine();
                System.out.println("Réponse du serveur : " + res);

                // Fermer la connexion
                s.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
