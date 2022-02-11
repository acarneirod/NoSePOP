import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TablaEmpleados {
    private JPanel panel1;
    private JTable table1;

    public TablaEmpleados(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Empleados");

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("EMPNO");
        tableModel.addColumn("ENAME");
        tableModel.addColumn("JOB");
        tableModel.addColumn("MGR");
        tableModel.addColumn("HIREDATE");
        tableModel.addColumn("SAL");
        tableModel.addColumn("COMM");
        tableModel.addColumn("DEPTNO");

        ArrayList<Empleados> empleados = (ArrayList<Empleados>) query.list();
        for(int i = 0; i<empleados.size();i++){
            tableModel.insertRow(0,empleados.get(i).contenido());
        }

        JFrame f = new JFrame();
        f.setTitle("Empleados");
        f.setSize(550, 350);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }
}
