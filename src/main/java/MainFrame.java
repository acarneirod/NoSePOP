import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JButton introducirDepartamentoButton;
    private JButton eliminarEmpleadoButton;
    private JButton introducirEmpleadoButton;
    private JButton mostrarInformaciónDeTablaButton;
    private JButton mostrarTablaDepartamentosButton;
    private JButton mostrarTablaEmpleadosButton;
    private JLabel label;
    private JButton eliminarDepartamentoButton;
    private JTextField textField1;

    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("NoSePOP");
        setSize(480,300);
        label.setText("Elige la opción deseada:");
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
        mostrarInformaciónDeTablaButton.addActionListener(new ActionListener() {
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
                new TablaEmpleados();
            }
        });
        introducirDepartamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TablaEmpleados();
            }
        });
        eliminarDepartamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TablaEmpleados();
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
