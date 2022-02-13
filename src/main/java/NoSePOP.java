
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

    /**
     * Método main del programa.
     */
    public static void main(String[] args) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        input = new Scanner(System.in);

        new MainFrame();

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
                    System.out.println("\n\tMOSTRANDO INFORMACIÓN DE LA TABLA EMPLEADOS Y LA TABLA DEPARTAMENTOS");
                    mostrarGeneral();
                    break;
                case 3:
                    System.out.println("\n\tINTRODUCIR EMPLEADO ...");
                    insertarEmpleado();
                    break;
                case 4:
                    System.out.println("\n\tELIMINAR EMPLEADO ...");
                    borrarEmpleado();
                    break;
                case 5:
                    System.out.println("\n\tINTRODUCIR DEPARTAMENTO ...");
                    insertarDepartamento();
                    break;
                case 6:
                    System.out.println("\n\tELIMINAR DEPARTAMENTO ...");
                    borrarDepartamento();
                    break;
                case 7:
                    System.out.println("GRACIAS POR UTILIZAR EL PROGRAMA, BUEN DIA. VUELVE PRONTO!!!");
                    break;
            }
        }while(opcion!=7);
        System.out.println("Pulsa Intro para continuar...");
        input.nextLine();
        // Se cierra la conexión a la BBDD y la entrada por teclado.
        input.close();
        HibernateUtil.closeSessionFactory();
    }

    /**
     * Menú que muestra las opciones con las que el usuario puede interactuar
     *
     * @return el valor de la opción
     */
    static int menu(){
        int opcion = -1;
        boolean valido = false;
        // Se muestra el menú hasta que se introduzca una opción valida o se salga del programa.
        do {
            System.out.println("0. Mostrar Tabla Empleados.");
            System.out.println("1. Mostrar Tabla Departamentos.");
            System.out.println("2. Mostrar información de Tabla Empleados y Tabla Departamentos.");
            System.out.println("3. Introducir empleado.");
            System.out.println("4. Eliminar empleado.");
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
    /**
     * Método que muestra un listado de la tabla empleados.
     */
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

    /**
     * Método que muestra un listado de la tabla Departamentos.
     */
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

    /**
     * Método que muestra un listado de los atributos empno,ename,sal,dname y loc dependiendo de cada empleado.
     */
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
    /**
     * Método que solicita y comprueba los atributos de un empleado a insertar.
     */
    static void insertarEmpleado(){
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

    /**
     * Método que solicita y comprueba el numero de empleado de un empleado a eliminar.
     */
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

    /**
     * Método que inserta un empleado en la base de datos.
     *
     * @param emp Empleado a insertar.
     */
    static void postEmp(Empleados emp){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Método que elimina un empleado de la base de datos.
     *
     * @param emp Empleado a eliminar.
     */
    static void delEmp(Empleados emp){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.delete(emp);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Método que busca un empleado de la base de datos.
     *
     * @param empno Empleado a buscar.
     * @return Empleado encontrado.
     */
    static Empleados getEmpleado(int empno){
        Session session = HibernateUtil.getCurrentSession();
        Empleados empleado = session.get(Empleados.class, empno);
        session.close();
        return empleado;
    }

    /**
     * Método que comprueba si un empleado existe en la base de datos.
     *
     * @param empno Empleado a buscar.
     * @return Empleado existe o no existe.
     */
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
    /**
     * Método que solicita y comprueba los atributos de un departamento a insertar.
     */
    static void insertarDepartamento(){
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

    /**
     * Método que solicita y comprueba el numero de departamento de un departamento a eliminar.
     */
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

    /**
     * Método que inserta un departamento en la base de datos.
     *
     * @param departamento Departamento a insertar.
     */
    static void postDep(Departamentos departamento){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(departamento);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Método que elimina un departamento de la base de datos.
     *
     * @param departamento Departamento a eliminar.
     */
    static void delDep(Departamentos departamento){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.delete(departamento);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Método que busca un departamento de la base de datos.
     *
     * @param deptno Departamento a buscar.
     * @return Departamento encontrado.
     */
    static Departamentos getDepartamento(int deptno){
        Session session = HibernateUtil.getCurrentSession();
        Departamentos departamento = session.get(Departamentos.class, deptno);
        session.close();
        return departamento;
    }

    /**
     * Método que comprueba si un departamento existe en la base de datos.
     *
     * @param deptno Departamento a buscar.
     * @return Departamento existe o no existe.
     */
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
    /**
     * Método que comprueba si String contiene números.
     *
     * @param res String a comprobar.
     * @return Contiene numeros o no.
     */
    static boolean comprobarNumerosEnString(String res){
        boolean numeros = false;
        for(int i = 0; i<res.length();i++){
            if(Character.isDigit(res.charAt(i))){
                System.out.println(": No puede introducir numeros...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
                numeros = true;
                break;
            }
        }
        return numeros;
    }

    /**
     * Método que comprueba si String contiene letras.
     *
     * @param res String a comprobar.
     * @return Contiene letras o no.
     */
    static boolean comprobarLetrasEnString(String res){
        boolean letras = false;
        for(int i = 0; i<res.length();i++){
            if(Character.isLetter(res.charAt(i))){
                System.out.println("ERROR: No puede introducir numeros...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
                letras = true;
                break;
            }
        }
        return letras;
    }

    /**
     * Método que comprueba si una fecha(String) está en el formato correcto.
     *
     * @param fecha String a comprobar.
     * @return Formato correcto o no.
     */
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
