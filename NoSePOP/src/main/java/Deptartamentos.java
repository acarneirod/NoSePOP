import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Deptartamentos {
    @Id
    //Numero del departamento
    @Column(name = "deptno")
    private int deptno;
    //Nombre del departamento
    @Column(name = "dname")
    private String dname;
    //Localizaci�n del departamento
    @Column(name = "loc")
    private String loc;

    public Deptartamentos(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Deptartamentos() {
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Deptartamentos{" + "deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + '}';
    }
    
    
}
