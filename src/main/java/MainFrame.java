import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JButton introducirDepartamentoButton;
    private JButton eliminarEmpleadoButton;
    private JButton introducirEmpleadoButton;
    private JButton mostrarInformaciĆ³nDeTablaButton;
    private JButton mostrarTablaDepartamentosButton;
    private JButton mostrarTablaEmpleadosButton;
    private JLabel label;
    private JButton eliminarDepartamentoButton;
    private JTextField textField1;

    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("NoSePOP");
        setSize(480,300);
        label.setText("Elige la opciĆ³n deseada:");
        mostrarTablaEmpleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TablaEmpleados();
            }
        });
        mostrarTablaDepartamentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TablaDepartamentos();
            }
        });
        mostrarInformaciĆ³nDeTablaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TablaEmpleadoYDepartamento();
            }
        });
        introducirEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IntroducirEmpleado();
            }
        });
        eliminarEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EliminarEmpleado();
            }
        });
        introducirDepartamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IntroducirDepartamento();
            }
        });
        eliminarDepartamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EliminarDepartamento();
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
