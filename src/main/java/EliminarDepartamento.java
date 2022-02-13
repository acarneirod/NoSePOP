import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarDepartamento extends JFrame{
    private JTextArea textArea1;
    private JButton ELIMINARButton;
    private JPanel mainPanel;

    public EliminarDepartamento() {
        setContentPane(mainPanel);
        setTitle("Eliminar departamento");
        setSize(480, 150);
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Departamentos dep = null;
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
                if(!NoSePOP.comprobarExisteDepartamento(Integer.parseInt(String.valueOf(textArea1.getText())))){
                    new INFO("El departamento no se encuentra en la base de datos!");
                    valido=false;
                }
                if(valido){
                    dep = NoSePOP.getDepartamento(Integer.parseInt(String.valueOf(textArea1.getText())));
                    new INFO("El departamento ha sido eliminado!");
                    NoSePOP.delDep(dep);
                    dispose();
                }
            }
        });
        setVisible(true);
    }
}
