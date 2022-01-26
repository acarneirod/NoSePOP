import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Emp {
    @Id
    @Column(name = "empno")
    private int empno;
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
}
