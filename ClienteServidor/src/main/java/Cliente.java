import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String [] args) {

        InetAddress direcc=null;
        try{
            direcc=InetAddress.getByName("localhost");
            System.out.println(direcc);
        }catch(UnknownHostException uhe){
            System.out.println("Host no encontrado: "+uhe);
            System.exit(-1);
        }

        int puerto=1234;
        Socket sckt=null;
        DataInputStream dis=null;
        DataOutputStream dos=null;
        try{
            System.out.println("Introduce el número del que quieres averiguar el factorial: ");
            Scanner sc=new Scanner(System.in);
            int numero=sc.nextInt();
            sckt = new Socket(direcc,puerto);
            dis=new DataInputStream(sckt.getInputStream());
            dos=new DataOutputStream (sckt.getOutputStream());
            dos.writeInt(numero);
            long resultado=dis.readLong();
            System.out.println("Solicitud = "+numero+"\tResultado = "+resultado);


            dis.close();
            dos.close();
        }catch (IOException e){
            System.err.println("Se ha producido la excepción: "+e);
        }

        try{
            if (sckt!=null) sckt.close();
        }catch(IOException ioe){
            System.err.println("Error al cerrar el socket: "+ioe);
        }
    }
}