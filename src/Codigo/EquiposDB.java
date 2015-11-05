/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

/**
 *
 * @author 
 */
import java.sql.*;
import java.util.ArrayList;
import static Codigo.Nueva.nteam;

public class EquiposDB{
    private Connection c;
    private Statement stmt;
    private int cont=1;
    
    public EquiposDB(){
        c = null;
        stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:Equipos.db");
          System.out.println("Conectado a Equipo.db");

          stmt = c.createStatement();
          String sql = "CREATE TABLE IF NOT EXISTS Equipos" +
                       "(ID INT NOT NULL," +
                       " Nombre TEXT NOT NULL, " + 
                       " Formacion TEXT," + 
                       " Arquero INT, " + 
                       " Defensor INT, " + 
                       " Mediocampo INT, " +                  
                       " Ataque INT, "    + 
                       " PRIMARY KEY(ID))";
          stmt.executeUpdate(sql);
          stmt.close();
          c.close();
        } catch ( ClassNotFoundException | SQLException e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Tabla "+nteam+" creada");
    }
    
    public ArrayList<String> getEquipos() throws SQLException, ClassNotFoundException{
        ArrayList<String> foo = new ArrayList();
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Equipos.db");
        c.setAutoCommit(false);
        System.out.println("Tabla Equipos abierta");
        stmt = c.createStatement();
        try (ResultSet rs = stmt.executeQuery( "SELECT Nombre FROM Equipos;" )) {
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("Nombre");
                String  form  = rs.getString("Formacion");
                int h1 = rs.getInt("Arquero");
                int h2 = rs.getInt("Defensor");
                int h3 = rs.getInt("Mediocampo");
                int h4 = rs.getInt("Ataque");
                foo.add(Integer.toString(id));
                foo.add(name);
                foo.add(form);
                foo.add(Integer.toString(h1));
                foo.add(Integer.toString(h2));
                foo.add(Integer.toString(h3));
                foo.add(Integer.toString(h4));
           }
        }
        stmt.close();
        c.close();
        System.out.println("Operation done successfully");
        return foo;
      }
        public void asd() throws SQLException{
            c = DriverManager.getConnection("jdbc:sqlite:Equipos.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
        ResultSet resultado=stmt.executeQuery("SELECT ID FROM Equipos");          
        while(resultado.next()){        
            resultado.getInt(cont);
            cont++;
        }}
    
    public Boolean insertarEquipo(String name,String form,int h1, int h2, int h3, int h4) throws ClassNotFoundException, SQLException{
        Connection c = null;
        Statement stmt = null;
        Boolean boo = true;
        try{
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Equipos.db");
        c.setAutoCommit(false);
        stmt = c.createStatement();   
            
        if(cont==1){
    asd();
}
            
       
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Equipos.db");
        c.setAutoCommit(false);
        stmt = c.createStatement();
        String sql = "INSERT INTO Equipos (ID,Nombre,Formacion,Arquero,Defensor,Mediocampo,Ataque) " +
        String.format("VALUES (%2d,'%s','%s',%2d,%2d,%2d,%2d);",cont,name,form,h1,h2,h3,h4); 
        stmt.executeUpdate(sql);
        cont++;
        System.out.println("Equipo insertado ");
        stmt.close();
        c.commit();
        c.close();
        }catch ( Exception e ) {
            System.out.println("Error en insertarEquipo");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return boo;
      
        
    
    }}