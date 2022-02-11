
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrián Carneiro
 * @author Jose Guilmar
 */
public class NoSePOP {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static Scanner input;
    
    public static void main(String[] args) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        input = new Scanner(System.in);
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 0:

                    System.out.println("\n\tMOSTRANDO TABLA EMPLEADOS ... ");
                    listadoTablaEmpleados();
                    break;
                case 1:
                    System.out.println("\n\tMOSTRANDO TABLA DEPARTAMENTOS ...");
                    listadoTablaDepartamentos();
                    break;
                case 2:
                    System.out.println("\n\tINTRODUCIR EMPLEADO ...");
                    añadirEmpleado();
                    break;
                case 3:
                    System.out.println("\n\tELIMINAR EMPLEADO ...");
                    borrarEmpleado();
                    break;
                case 4:
                    System.out.println("\n\tMOSTRANDO INFORMACIÓN DE LA TABLA EMPLEADOS Y LA TABLA DEPARTAMENTOS");
                    mostrarGeneral();
                    break;
                case 5:
                    System.out.println("\n\tINTRODUCIR DEPARTAMENTO ...");
                    añadirDepartamento();
                    break;
                case 6:
                    System.out.println("\n\tELIMINAR DEPARTAMENTO ...");
                    borrarDepartamento();
                    break;
                case 7:
                    System.out.println("GRACIAS POR UTILIZAR EL PROGRAMA, BUEN DÍA. VUELVE PRONTO!!!");
                    break;
            }
        }while(opcion!=7);
        System.out.println("Pulsa Intro para continuar...");
        input.nextLine();
        // Se cierra la conexión a la BBDD y la entrada por teclado.
        input.close();
        HibernateUtil.closeSessionFactory();
    }

    static int menu(){
        int opcion = -1;
        boolean valido = false;
        // Se muestra el menú hasta que se introduzca una opción valida o se salga del programa.
        do {
            System.out.println("0. Mostrar Tabla Empleados.");
            System.out.println("1. Mostrar Tabla Departamentos.");
            System.out.println("2. Introducir empleado.");
            System.out.println("3. Eliminar empleado.");
            System.out.println("4. Mostrar información de Tabla Empleados y Tabla Departamentos.");
            System.out.println("5. Introducir departamento.");
            System.out.println("6. Eliminar departamento.");
            System.out.println("7. Salir.");

            try {
                System.out.println("Elija una opcion: ");
                opcion = Integer.parseInt(input.nextLine());

                if (opcion < 0 || opcion > 7) {
                    System.out.println("ERROR: Opción Inválida...");
                    System.out.print("Pulsa Intro para continuar...");
                    input.nextLine();
                } else {
                    valido = true;
                }

            } catch (NumberFormatException nfe) {
                System.out.println("ERROR: Debe introducir solo números...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
            }
        }while(!valido);
        return opcion;
    }

    //LISTADOS
    static void listadoTablaEmpleados(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Empleados");
        ArrayList<Empleados> empleados = (ArrayList<Empleados>) query.list();
        for(int i = 0; i<empleados.size();i++){
            System.out.println("---------------------------");
            System.out.println("EMPNO: " + empleados.get(i).getEmpno());
            System.out.println("ENAME: " + empleados.get(i).getEname());
            System.out.println("JOB: " + empleados.get(i).getJob());
            System.out.println("MGR: " + empleados.get(i).getMgr());
            System.out.println("HIREDATE: " + empleados.get(i).getHiredate());
            System.out.println("SAL: " + empleados.get(i).getSal());
            System.out.println("COMM: " + empleados.get(i).getComm());
            System.out.println("DEPTNO: " + empleados.get(i).getDeptno());
        }
        System.out.println("---------------------------");
    }

    static void listadoTablaDepartamentos(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Departamentos");
        ArrayList<Departamentos> departamentos = (ArrayList<Departamentos>) query.list();
        for(int i = 0; i<departamentos.size();i++){
            System.out.println("---------------------------");
            System.out.println("DEPTNO: " + departamentos.get(i).getDeptno());
            System.out.println("DNAME: " + departamentos.get(i).getDname());
            System.out.println("LOC: " + departamentos.get(i).getLoc());
        }
        System.out.println("---------------------------");
    }

    static void mostrarGeneral(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Empleados");
        ArrayList<Empleados> empleados = (ArrayList<Empleados>) query.list();
        for(int i = 0; i<empleados.size();i++){
            System.out.println("---------------------------");
            System.out.println("EMPNO: " + empleados.get(i).getEmpno());
            System.out.println("ENAME: " + empleados.get(i).getEname());
            System.out.println("SAL: " + empleados.get(i).getSal());
            Departamentos departamento = getDepartamento(empleados.get(i).getDeptno());
            System.out.println("DNAME: " + departamento.getDname());
            System.out.println("LOC: " + departamento.getLoc());
        }
        System.out.println("---------------------------");
    }
    //LISTADOS



    //EMPLEADOS
    static void añadirEmpleado(){
        String res = null;
        boolean valido;

        Empleados emp = new Empleados();

        //EMPNO
        valido = false;
        do {
            try {
                do {
                    System.out.println("Introduce numero de empleado: ");
                    res = input.nextLine();
                }while(comprobarExisteEmpleado(Integer.parseInt(res)));
                valido = true;
                emp.setEmpno(Integer.parseInt(res));
            }catch(NumberFormatException nfe) {
                System.out.println("ERROR: Debe introducir solo números...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
            }
        }while(!valido);
        //ENAME
        do{
            valido=true;
            do {
                System.out.println("Introduce nombre de empleado: ");
                res = input.nextLine();
            }while(res.length()<1||res.length()>30);
            if(comprobarNumerosEnString(res)){
                valido = false;
            }
            if (valido = true) emp.setEname(res);
        }while(!valido);
        //JOB
        do{
            valido=true;
            do {
                System.out.println("Introduce job de empleado: ");
                res = input.nextLine();
            }while(res.length()<1||res.length()>30);
            if(comprobarNumerosEnString(res)){
                valido = false;
            }
            if (valido = true) emp.setJob(res);
        }while(!valido);
        //MGR
        valido = false;
        do {
            try {
                System.out.println("Introduce MGR de empleado: ");
                res = input.nextLine();
            }catch(NumberFormatException nfe) {
                System.out.println("ERROR: Debe introducir solo números...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
            }
            valido=true;
            emp.setMgr(Integer.parseInt(res));
        }while(!valido);
        //HIREDATE
        do{
            System.out.println("Introduce hiredate de empleado: ");
            res = input.nextLine();
            valido=comprobarFecha(res);
        }while(!valido);
        emp.setHiredate(java.sql.Date.valueOf(res));
        //SAL
        do {
            try {
                System.out.println("Introduce SAL de empleado: ");
                res = input.nextLine();
            }catch(NumberFormatException nfe) {
                System.out.println("ERROR: Debe introducir solo números...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
            }
            valido=true;
            emp.setSal(Integer.parseInt(res));
        }while(!valido);
        //COMM
        valido = false;
        do {
            try {
                System.out.println("Introduce comm de empleado: ");
                res = input.nextLine();
            }catch(NumberFormatException nfe) {
                System.out.println("ERROR: Debe introducir solo números...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
            }
            valido=true;
            emp.setComm(Integer.parseInt(res));
        }while(!valido);
        //DEPTNO
        valido = false;
        do {
            try {
                do {
                    System.out.println("Introduce numero de departamento: ");
                    res = input.nextLine();
                }while(!comprobarExisteDepartamento(Integer.parseInt(res)));
                valido = true;
                emp.setDeptno(Integer.parseInt(res));
            }catch(NumberFormatException nfe) {
                System.out.println("ERROR: Debe introducir solo números...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
            }
        }while(!valido);
        postEmp(emp);
    }
    static void borrarEmpleado(){
        String res = null;
        Empleados emp = null;
        try {
            do {
                System.out.println("Introduce numero de empleado: ");
                res = input.nextLine();
            }while(!comprobarExisteEmpleado(Integer.parseInt(res)));
            emp = getEmpleado(Integer.parseInt(res));
        }catch(NumberFormatException nfe) {
            System.out.println("ERROR: Debe introducir solo números...");
            System.out.println("Pulsa Intro para continuar ...");
            input.nextLine();
        }
        delEmp(emp);
    }
    static void postEmp(Empleados emp){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();
        session.close();
    }
    static void delEmp(Empleados emp){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.delete(emp);
        session.getTransaction().commit();
        session.close();
    }
    static Empleados getEmpleado(int empno){
        Session session = HibernateUtil.getCurrentSession();
        Empleados empleado = session.get(Empleados.class, empno);
        session.close();
        return empleado;
    }
    static boolean comprobarExisteEmpleado(int empno){
        boolean existe = true;
        Empleados empleado = getEmpleado(empno);
        if(empleado==null){
            System.out.println("El empleado no se encuentra en la base de datos...");
            System.out.println("Pulsa Intro para continuar ...");
            input.nextLine();
            existe = false;
        }else{
            System.out.println("El empleado se encuentra en la base de datos...");
            System.out.println("Pulsa Intro para continuar ...");
            input.nextLine();
        }
        return existe;
    }
    //EMPLEADOS



    //DEPARTAMENTOS
    static void añadirDepartamento(){
        String res = null;
        boolean valido;

        Departamentos departamento = new Departamentos();
        //DEPTNO
        valido = false;
        do {
            try {
                do {
                    System.out.println("Introduce numero de departamento: ");
                    res = input.nextLine();
                }while(comprobarExisteDepartamento(Integer.parseInt(res)));
                valido = true;
                departamento.setDeptno(Integer.parseInt(res));
            }catch(NumberFormatException nfe) {
                System.out.println("ERROR: Debe introducir solo números...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
            }
        }while(!valido);
        //DNAME
        do{
            valido=true;
            do {
                System.out.println("Introduce nombre de departamento: ");
                res = input.nextLine();
            }while(res.length()<1||res.length()>30);
            if(comprobarNumerosEnString(res)){
                valido = false;
            }
            if (valido = true) departamento.setDname(res);
        }while(!valido);
        //LOC
        do{
            valido=true;
            do {
                System.out.println("Introduce LOC de departamento: ");
                res = input.nextLine();
            }while(res.length()<1||res.length()>30);
            if(comprobarNumerosEnString(res)){
                valido = false;
            }
            if (valido = true) departamento.setLoc(res);
        }while(!valido);
        postDep(departamento);
    }
    static void borrarDepartamento(){
        String res = null;
        Departamentos departamento = null;
        try {
            do {
                System.out.println("Introduce numero de departamento: ");
                res = input.nextLine();
            }while(!comprobarExisteDepartamento(Integer.parseInt(res)));
            departamento = getDepartamento(Integer.parseInt(res));
        }catch(NumberFormatException nfe) {
            System.out.println("ERROR: Debe introducir solo números...");
            System.out.println("Pulsa Intro para continuar ...");
            input.nextLine();
        }
        delDep(departamento);
    }
    static void postDep(Departamentos departamento){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(departamento);
        session.getTransaction().commit();
        session.close();
    }
    static void delDep(Departamentos departamento){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.delete(departamento);
        session.getTransaction().commit();
        session.close();
    }
    static Departamentos getDepartamento(int deptno){
        Session session = HibernateUtil.getCurrentSession();
        Departamentos departamento = session.get(Departamentos.class, deptno);
        session.close();
        return departamento;
    }
    static boolean comprobarExisteDepartamento(int deptno){
        boolean existe = true;
        Departamentos departamento = getDepartamento(deptno);
        if(departamento==null){
            System.out.println("El departamento no se encuentra en la base de datos...");
            System.out.println("Pulsa Intro para continuar ...");
            input.nextLine();
            existe = false;
        }else{
            System.out.println("El departamento se encuentra en la base de datos...");
            System.out.println("Pulsa Intro para continuar ...");
            input.nextLine();
        }
        return existe;
    }
    //DEPARTAMENTOS




    //UTILS
    static boolean comprobarNumerosEnString(String res){
        boolean numeros = false;
        for(int i = 0; i<res.length();i++){
            if(Character.isDigit(res.charAt(i))){
                System.out.println("ERROR: No puede introducir numeros...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
                numeros = true;
                break;
            }
        }
        return numeros;
    }
    static boolean comprobarFecha(String fecha) {
        boolean formato = true;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setLenient(false);
            formatter.parse(fecha);
            formato = true;
        } catch (ParseException e) {
            System.out.println("El formato introducido no es correcto. Formato correcto: yyyy-MM-dd");
            formato = false;
        }
        return formato;
    }
    //UTILS
}
