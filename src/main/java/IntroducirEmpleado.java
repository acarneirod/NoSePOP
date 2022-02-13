import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroducirEmpleado extends JFrame{
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JTextArea textArea6;
    private JTextArea textArea7;
    private JTextArea textArea8;
    private JButton INSERTARButton;

    public IntroducirEmpleado() {
        setContentPane(mainPanel);
        setTitle("Introducir empleado");
        setSize(480,700);
        INSERTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = null;
                boolean valido=true;

                Empleados emp = new Empleados();

                if(String.valueOf(textArea1.getText()).isBlank()||String.valueOf(textArea1.getText()).isEmpty()){valido=false;}
                if(String.valueOf(textArea2.getText()).isBlank()||String.valueOf(textArea2.getText()).isEmpty()){valido=false;}
                if(String.valueOf(textArea3.getText()).isBlank()||String.valueOf(textArea3.getText()).isEmpty()){valido=false;}
                if(String.valueOf(textArea4.getText()).isBlank()||String.valueOf(textArea4.getText()).isEmpty()){valido=false;}
                if(String.valueOf(textArea6.getText()).isBlank()||String.valueOf(textArea6.getText()).isEmpty()){valido=false;}
                if(String.valueOf(textArea7.getText()).isBlank()||String.valueOf(textArea7.getText()).isEmpty()){valido=false;}
                if(String.valueOf(textArea8.getText()).isBlank()||String.valueOf(textArea8.getText()).isEmpty()){valido=false;}
                if(valido!=false){
                    if(NoSePOP.comprobarExisteEmpleado(Integer.parseInt(String.valueOf(textArea1.getText())))){
                        new INFO("El empleado ya se encuentra en la base de datos!");
                        valido=false;}

                    if(NoSePOP.comprobarLetrasEnString(String.valueOf(textArea1.getText()))){
                        new INFO("El ENUM solo puede contener numeros!");
                        valido=false;}
                    if(NoSePOP.comprobarNumerosEnString(String.valueOf(textArea2.getText()))){
                        new INFO("El ENAME solo puede contener letras!");
                        valido=false;}
                    if(NoSePOP.comprobarNumerosEnString(String.valueOf(textArea3.getText()))){
                        new INFO("El JOB solo puede contener letras!");
                        valido=false;}
                    if(NoSePOP.comprobarLetrasEnString(String.valueOf(textArea4.getText()))){
                        new INFO("El MGR solo puede contener numeros!");
                        valido=false;}
                    if(!NoSePOP.comprobarFecha(String.valueOf(textArea5.getText()))){
                        new INFO("El formato de fecha introducido no es correcto. Formato correcto: yyyy-MM-dd!");
                        valido=false;}
                    if(NoSePOP.comprobarLetrasEnString(String.valueOf(textArea6.getText()))){
                        new INFO("El SAL solo puede contener numeros!");
                        valido=false;}
                    if(NoSePOP.comprobarLetrasEnString(String.valueOf(textArea7.getText()))){
                        new INFO("El COMM solo puede contener numeros!");
                        valido=false;}
                    if(NoSePOP.comprobarLetrasEnString(String.valueOf(textArea8.getText()))){
                        new INFO("El DEPTNO solo puede contener numeros!");
                        valido=false;}

                    if(!NoSePOP.comprobarExisteDepartamento(Integer.parseInt(String.valueOf(textArea8.getText())))){
                        new INFO("El DEPTNO introducido no se corresponde con ningun departamento!");
                        valido=false;}

                    if(String.valueOf(textArea2.getText()).length()<1||String.valueOf(textArea2.getText()).length()>30){
                        new INFO("El limite del ENAME se encuentra en 30 caracteres");
                        valido=false;}
                    if(String.valueOf(textArea3.getText()).length()<1||String.valueOf(textArea3.getText()).length()>30){
                        new INFO("El limite del JOB se encuentra en 30 caracteres!");
                        valido=false;}

                }else{
                    new INFO("Debe rellenar todos los campos!");
                }
                if(valido){
                    emp.setEmpno(Integer.parseInt(String.valueOf(textArea1.getText())));
                    emp.setEname(String.valueOf(textArea2.getText()));
                    emp.setJob(String.valueOf(textArea3.getText()));
                    emp.setMgr(Integer.parseInt(String.valueOf(textArea4.getText())));
                    emp.setHiredate(java.sql.Date.valueOf(String.valueOf(textArea5.getText())));
                    emp.setSal(Integer.parseInt(String.valueOf(textArea6.getText())));
                    emp.setComm(Integer.parseInt(String.valueOf(textArea7.getText())));
                    emp.setDeptno(Integer.parseInt(String.valueOf(textArea8.getText())));
                    NoSePOP.postEmp(emp);
                    new INFO("Empleado insertado!");
                    dispose();
                }
            }
        });
        setVisible(true);
    }



}
