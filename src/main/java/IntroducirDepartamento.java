import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroducirDepartamento extends JFrame{
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton INSERTARButton;
    private JPanel mainPanel;

    public IntroducirDepartamento(){
        setContentPane(mainPanel);
        setTitle("Introducir empleado");
        setSize(480,400);
        INSERTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean valido = true;
                Departamentos departamento = new Departamentos();

                if(String.valueOf(textArea1.getText()).isBlank()||String.valueOf(textArea1.getText()).isEmpty()){valido=false;}
                if(String.valueOf(textArea2.getText()).isBlank()||String.valueOf(textArea3.getText()).isEmpty()){valido=false;}
                if(String.valueOf(textArea2.getText()).isBlank()||String.valueOf(textArea3.getText()).isEmpty()){valido=false;}
                if(valido){
                    if(NoSePOP.comprobarExisteDepartamento(Integer.parseInt(String.valueOf(textArea1.getText())))){
                        new INFO("El departamento ya se encuentra en la base de datos!");
                        valido=false;}
                    if(NoSePOP.comprobarLetrasEnString(String.valueOf(textArea1.getText()))){
                        new INFO("El DEPTNO solo puede contener numeros!");
                        valido=false;}
                    if(NoSePOP.comprobarNumerosEnString(String.valueOf(textArea2.getText()))){
                        new INFO("El DNAME solo puede contener letras!");
                        valido=false;}
                    if(NoSePOP.comprobarNumerosEnString(String.valueOf(textArea3.getText()))){
                        new INFO("LOC solo puede contener letras!");
                        valido=false;}
                    if(String.valueOf(textArea2.getText()).length()<1||String.valueOf(textArea2.getText()).length()>30){
                        new INFO("El limite del DNAME se encuentra en 30 caracteres");
                        valido=false;}
                    if(String.valueOf(textArea3.getText()).length()<1||String.valueOf(textArea2.getText()).length()>30){
                        new INFO("El limite de LOC se encuentra en 30 caracteres");
                        valido=false;}
                }else{
                    new INFO("Debe rellenar todos los campos!");
                }
                if(valido){
                    departamento.setDeptno(Integer.parseInt(String.valueOf(textArea1.getText())));
                    departamento.setDname(String.valueOf(textArea2.getText()));
                    departamento.setLoc(String.valueOf(textArea3.getText()));
                    NoSePOP.postDep(departamento);
                    new INFO("Departamento insertado!");
                    dispose();
                }

            }
        });
        setVisible(true);
    }
}
