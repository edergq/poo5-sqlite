package mantenimiento;
import Entidades.Persona;
import conexion.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
public class Mpersona {    
        Statement stmt=null;
        Conexion cx = new Conexion();        
    public void registrarPersona(Persona p){        
        String sql = " INSERT INTO personas( id, nombres, sexo) "+
                     " VALUES('"+p.getS_id()+"','"+p.getS_nombres()+"','"+p.getS_sexo()+"') ";
            try {
                stmt= cx.connect().createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
                cx.connect().close();
                System.out.println("consulta:"+sql);
                System.out.println("Se registro satisfactoriamente");
            } catch (SQLException ex) {
                System.out.print("Capturar erro: "+ex.getMessage());
            }
    }
    
    public static void main(String[] args) {
        Mpersona mp= new Mpersona();
        Persona p1= new Persona();
        p1.setS_id(1);
        p1.setS_nombres("Eder");
        p1.setS_sexo("M");
        mp.registrarPersona(p1);
    }
}
