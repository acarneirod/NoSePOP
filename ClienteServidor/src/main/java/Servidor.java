import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor {
    public static void main(String args[]) {

        try {
            System.out.println("LocalHost = " + InetAddress.getLocalHost().toString());
        } catch (UnknownHostException uhe) {
            System.err.println("No puedo saber la dirección IP local: " + uhe);
        }

        ServerSocket ss = null;
        try {
            ss = new ServerSocket(1234);
        } catch (IOException ioe) {
            System.err.println("Error al abrir el socket del servidor: " + ioe);
            System.exit(-1);
        }

        long entrada;
        long salida;
        while(true){
            try{
                Socket sckt=ss.accept();
                DataInputStream dis=new DataInputStream(sckt.getInputStream());
                DataOutputStream dos=new DataOutputStream(sckt.getOutputStream());
                int puerto=sckt.getPort();
                InetAddress direcc=sckt.getInetAddress();


                entrada=dis.readInt();
                salida= (calculoFactorial(entrada));
                dos.writeLong(salida);



                dis.close();
                dos.close();
                sckt.close();
            }catch (IOException e){
                System.err.println("Se ha producido la excepción: "+e);
            }
        }
    }
}