import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class06IncrementoSalarialEmpleados {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        try {
            //CONEXION DRIVER (JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306//hospital";
            Connection cn = DriverManager.getConnection(connectionString, "root", "root");
            

            //PETICION USUARIO
            System.out.println("Escribe funcionque recibirá el aumento de sueldo");
            String oficio = teclado.nextLine();
            oficio.toUpperCase();
            System.out.println("Escribe cantidad de aumento de sueldo");
            String incremento = teclado.nextLine();

            //UPDATE CON RESULTADO DE PETICIONES: update EMP set SALARIO = SALARIO + 1 where OFICIO='ANALISTA'
            String sql = "Update EMP set SALARIO = SALARIO +" + incremento + "where OFICIO=" + oficio + "'";
            Statement st = cn.createStatement();
            
            //UPDATE
            String listaSql = "SELECT APELLIDO, FUNCION, SALARIO, SALARIO"  + incremento + "as INCREMENTO from PLANTILLA order by FUNCION;";
            ResultSet rs = st.executeQuery(listaSql);

            while (rs.next()){
                String ape = rs.getString("APELLIDO");
                String func = rs.getString("FUNCION");
                String sal = rs.getString("SALARIO");
                String salnew = rs.getString("INCREMENTO");
                System.out.println(ape + " - " + func + " - " + sal + " - " + salnew);
            }

            //CERRAMOS CONEXION
            rs.close();
            cn.close();

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }

    }
}
