import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TablaEmpleadoYDepartamento {
    private JPanel panel1;
    private JTable table1;

    public TablaEmpleadoYDepartamento(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Empleados");

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("EMPNO");
        tableModel.addColumn("ENAME");
        tableModel.addColumn("SAL");
        tableModel.addColumn("DNAME");
        tableModel.addColumn("LOC");

        ArrayList<Empleados> empleados = (ArrayList<Empleados>) query.list();
        for(int i = 0; i<empleados.size();i++){
            Departamentos departamento = NoSePOP.getDepartamento(empleados.get(i).getDeptno());
            String[] content = {String.valueOf(empleados.get(i).getEmpno()),String.valueOf(empleados.get(i).getEname()),String.valueOf(empleados.get(i).getSal()),
                    String.valueOf(departamento.getDname()),String.valueOf(departamento.getLoc())};
            tableModel.insertRow(0,content);
        }

        JFrame f = new JFrame();
        f.setTitle("Empleados y departamentos");
        f.setSize(550, 350);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }

}
