import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class07AccionesDepartamentos {
    public static void main(String[] args) {
        // Mostrar departamentos al usuario cuando inicia la aplicacion
        // Mostramos menu para elegir que hará el usuario:
            //1· Insertar departamento
            //2· Modificador departamento
            //3· Eliminar departamento

        Scanner teclado = new Scanner(System.in);

        try {
            //CONEXION CON DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jbdc:mysql://localhost:3306//hospital";
            Connection cn = DriverManager.getConnection(connectionString, "root", "root");

            //CONSULTA: SELECT * FROM DEPT;
            String depts = "SELECT * FROM DEPT;";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(depts);
            //MOSTRAR CONSULTA
            while (rs.next()){
                System.out.println(rs.getString("DEPT"));
            }

            //PEDIMOS AL USUARIO
            System.out.println("Elija opcion escribiendo numero:" +
                                    "\n  1· INSERTAR departamento" +
                                    "\n  2· MODIFICAR departamento" +
                                    "\n  3· ELIMINAR departamento");
            int opcion = Integer.parseInt(teclado.nextLine());
            makeOption(opcion ,rs);
            
            //  1· INSERTAR DEPARTAMENTO
            if (opcion == 1){
                System.out.println("Escriba nombre del departamento a insertar: ");
                String newDept = teclado.nextLine();
                System.out.println("Escriba localización del departamento: ");
                String locNewDept = teclado.nextLine();
                //Hay que recorrer todos los id para añadir el nuevo
                
                String idNewDept;
                //AÑADIR FILA A TABLA
            }
            // 2· MODIFICAR DEPARTAMENTO
            else if (opcion == 2){
                System.out.println("Escriba departamento a modificar");
                System.out.println("introduzca atributo a modificar");
            }
            // 3· ELIMINAR DEPARTAMENTO
            else if (opcion == 3){
                System.out.println("Escriba id del departamento a eliminar");

            }
            else {
                System.out.println("ERROR: No has seleccionado una opción válida");
            }

            //LIBERAR RESULTADO y CERRAR CONEXION 
            rs.close();
            cn.close();


            } catch (Exception e) {
               System.out.println("ERROR: " + e);
            }
        
    }
    
    public static void makeOption(int opcion , ResultSet rs){
            
        Scanner in = new Scanner(System.in);
        
    
    }
}
