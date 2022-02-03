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
    private int ename;
    @Column(name = "job")
    private int job;
    @Column(name = "mgr")
    private int mgr;
    @Column(name = "hiredate")
    private int hiredate;
    @Column(name = "sal")
    private int sal;
    @Column(name = "comm")
    private int comm;
    @Column(name = "deptno")
    private int deptno;

    public Empleados(int empno, int ename, int job, int mgr, int hiredate, int sal, int comm, int deptno) {
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

    public int getEname() {
        return ename;
    }

    public void setEname(int ename) {
        this.ename = ename;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public int getHiredate() {
        return hiredate;
    }

    public void setHiredate(int hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
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
