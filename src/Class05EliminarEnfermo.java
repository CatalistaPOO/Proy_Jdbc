import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Class05EliminarEnfermo {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306//hospital";
            Connection cn = DriverManager.getConnection(connectionString, "root", "root");

            System.out.println("Inscripcion del enfermo a eliminar");
            String inscripcion = teclado.nextLine();

            // Consulta: delete from ENFERMO where INSCRIPCION=numero del enfermo;
            String sql = "delete from ENFERMO where INSCRIPCION=" + inscripcion; 
            Statement st = cn.createStatement();
            String sqlSelect = "Select * from ENFERMO";
            ResultSet rs = st.executeQuery(sqlSelect);
            while (rs.next()){
                String ins = rs.getString("INSCRIPCION");
                String ape = rs.getString("APELLIDO");
                System.out.println(ins + " - " + ape);
            }
            
            //reutilizamos Statement para nueva consulta
            int deleted = st.executeUpdate(sql);
            System.out.println("Enfermos eliminados: " + deleted);

            //Una vez terminadas las consultas, CERRAMOS CONEXION Y RESULT
            rs.close();
            cn.close();
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }


    }
}
