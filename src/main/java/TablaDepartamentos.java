import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TablaDepartamentos {
    private JPanel panel1;
    private JTable table1;

    public TablaDepartamentos() {
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Departamentos");

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("DEPTNO");
        tableModel.addColumn("DNAME");
        tableModel.addColumn("LOC");

        ArrayList<Departamentos> departamentos = (ArrayList<Departamentos>) query.list();
        for (int i = 0; i < departamentos.size(); i++) {
            tableModel.insertRow(0, departamentos.get(i).contenido());
        }

        JFrame f = new JFrame();
        f.setTitle("Departamentos");
        f.setSize(550, 350);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }
}
