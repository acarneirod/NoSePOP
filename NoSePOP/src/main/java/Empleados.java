import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Empleados {
    @Id
    //N�mero del empleado
    @Column(name = "empno")
    private int empno;
    //
    @Column(name = "ename")
    private String ename;
    @Column(name = "job")
    private String job;
    @Column(name = "mgr")
    private String mgr;
    @Column(name = "hiredate")
    private String hiredate;
    @Column(name = "sal")
    private String sal;
    @Column(name = "comm")
    private String comm;
    @Column(name = "deptno")
    private int deptno;

    public Empleados(int empno, String ename, String job, String mgr, String hiredate, String sal, String comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public Empleados() {
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMgr() {
        return mgr;
    }

    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "Emp{" + "empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + '}';
    }
    
    
    
}
