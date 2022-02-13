import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarEmpleado extends JFrame{
    private JTextArea textArea1;
    private JPanel mainPanel;
    private JButton ELIMINARButton;

    public EliminarEmpleado(){
        setContentPane(mainPanel);
        setTitle("Introducir empleado");
        setSize(480,300);
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleados emp = null;
                boolean valido=true;

                if(String.valueOf(textArea1.getText()).isBlank()||String.valueOf(textArea1.getText()).isEmpty()){
                    new INFO("Debes introducir un valor!");
                    valido=false;
                }
                if(NoSePOP.comprobarLetrasEnString(String.valueOf(textArea1.getText()))){
                    new INFO("Solo puede contener numeros!");
                    valido=false;
                }
                if(String.valueOf(textArea1.getText()).length()<1||String.valueOf(textArea1.getText()).length()>30){
                    new INFO("No puedes introducir más de 30 caractéres!");
                    valido=false;
                }
                if(!NoSePOP.comprobarExisteEmpleado(Integer.parseInt(String.valueOf(textArea1.getText())))){
                    new INFO("El empleado no se encuentra en la base de datos!");
                    valido=false;
                }
                if(valido){
                    emp = NoSePOP.getEmpleado(Integer.parseInt(String.valueOf(textArea1.getText())));
                    new INFO("El empleado ha sido eliminado!");
                    NoSePOP.delEmp(emp);
                    dispose();
                }
            }
        });
        setVisible(true);
    }


}
