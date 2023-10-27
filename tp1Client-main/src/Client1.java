import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public Client1() {
    }

    public static void main(String[] var0) {
        try {
            Socket var1 = new Socket("localhost", 8082);
            InputStream var2 = var1.getInputStream();
            OutputStream var3 = var1.getOutputStream();
            Scanner var4 = new Scanner(System.in);
            System.out.println("Donner un nombre");
            int var5 = var4.nextInt();
            var3.write(var5);
            int var6 = var2.read();
            System.out.println("Res =" + var6);
            var3.write(var6);
            var1.close();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }
}