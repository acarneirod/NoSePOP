import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Dept {
    @Id
    @Column(name = "deptno")
    private int deptno;
    @Column(name = "dname")
    private String dname;
    @Column(name = "loc")
    private String loc;
}
