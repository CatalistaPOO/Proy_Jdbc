import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Class04InsertarDepartamento {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        try {
            //CONEXION MEDIANTE DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");
                String connectionString = "jdbc:mysql://localhost:3306/hospital";
                Connection cn = DriverManager.getConnection(connectionString,"root", "root");

            //Seteamos los commit a desactivado
            cn.setAutoCommit(false);

            //PEDIMOS AL USUARIO PARA SETEAR LA CONSULTA
            System.out.println("Id departamento");
            String id = teclado.nextLine();
            System.out.println("Nombre departamento");
            String nombre = teclado.nextLine();
            System.out.println("Localidad");
            String loc = teclado.nextLine();

            //REALIZAMOS LA CONSULTA
            //consulta chequeada en Workbench: insert into DEPT values(50, 'TEST', 'LOCTEST')
            String sql = "insert into DEPT values (" + id + ", '" + nombre + "', '" + loc + "')";
            
            Statement st = cn.createStatement();
            int registros = st.executeUpdate(sql);
            System.out.println("Registros insertados: " + registros);

            //HACEMOS LOS CAMBIOS EN LA BBDD commit(si autocommit es false : set autocommit(false))
            //Al ser una base de datos transaccional(mysql,oracle...) debemos indicar que los cambios son permanentes
            // 1· Permanente: commit
            // 2· Deshacer cambios: rollback
            cn.commit();

            //CERRAMOS CONEXION
            cn.close();


        } catch (Exception e) {
           System.out.println("ERROR: " + e);
        }

    }
}
