/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import static Codigo.Nueva.nteam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fran
 */
import java.awt.Window;
public class PlantillasDB {
    private Connection c;
    private Statement stmt;
    
    
    
    public PlantillasDB(){
        c = null;
        stmt = null;

    }
    public void CrearPlantilla (){
        try {
          Class.forName("com.mysql.jdbc.Driver");

          c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Plantilla","root", "camilo");
          System.out.println("Tabla "+nteam+" Abierta");

          stmt = c.createStatement();
          String sql = "CREATE TABLE IF NOT EXISTS "+nteam +
                       "(ID INT NOT NULL AUTO_INCREMENT," +
                       " Nombre TEXT NOT NULL, " + 
                       " Posicion TEXT, " + 
                       " Arquero INT, " + 
                       " Defensor INT, " + 
                       " Mediocampo INT, " +                  
                       " Ataque INT, " +                  
                       " posX INT, " +                                   
                       " posY INT, " + 
                       " PRIMARY KEY(ID))";
          
          stmt.executeUpdate(sql);
          stmt.close();
          c.close();
        } catch ( ClassNotFoundException | SQLException e ) {
            System.out.println("error en plantillasdb plantillasdb");
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Tabla Plantilla creada");        
    }
    
    public ArrayList<String> getPlantillas() throws SQLException, ClassNotFoundException{
        ArrayList<String> foo = new ArrayList();
Class.forName("com.mysql.jdbc.Driver");
          c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Plantilla","root", "camilo");
        c.setAutoCommit(false);
        System.out.println("Tabla Plantilla abierta");
        stmt = c.createStatement();
        try (ResultSet rs = stmt.executeQuery( "SELECT * FROM Plantilla;" )) {
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String name = rs.getString("Nombre");
                String pos = rs.getString("Posicion");
                int h1 = rs.getInt("Arquero");
                int h2 = rs.getInt("Defensor");
                int h3 = rs.getInt("Mediocampo");
                int h4 = rs.getInt("Ataque");
                int posX = rs.getInt("posX");
                int posY = rs.getInt("posY");
                foo.add(Integer.toString(id));
                foo.add(name);
                foo.add(pos);
                foo.add(Integer.toString(h1));
                foo.add(Integer.toString(h2));
                foo.add(Integer.toString(h3));
                foo.add(Integer.toString(h4));
                foo.add(Integer.toString(posX));
                foo.add(Integer.toString(posY));
           }
        }
        stmt.close();
        c.close();
        System.out.println("Operation done successfully");
        return foo;
      }
    private int cont=1;
    private int conta=1;
    public Boolean insertarPlantilla(String name,String pos,int h1, int h2, int h3, int h4, int posX, int posY) throws ClassNotFoundException, SQLException{
        
        Connection c = null;
        Statement stmt = null;
        Boolean boo = true;
        
        try{
          Class.forName("com.mysql.jdbc.Driver");
          c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Plantilla","root", "camilo");
           // for (int d = 0; d < 20; d++) {
              // asd(); 
          //  }
           
            c.setAutoCommit(false);
            stmt = c.createStatement();
            
            String sql = "INSERT INTO "+nteam+" (ID,Nombre,Posicion,Arquero,Defensor,Mediocampo,Ataque,posX,posY)" +
            String.format("VALUES (%2d,'%s','%s',%2d,%2d,%2d,%2d,%2d,%2d);",conta,name,pos,h1,h2,h3,h4,posX,posY);
            conta++;
            stmt.executeUpdate(sql);
            System.out.println("Jugador insertado en plantilla");
            stmt.close();
            c.commit();
            c.close();
        }catch ( Exception e ) {
            System.out.println("Error en PlantillasDB insertarplantilla");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return boo;
      
        
    
    }
    
    public void asd() throws SQLException{
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Plantilla","root", "camilo");
            c.setAutoCommit(false);
            stmt = c.createStatement();
        ResultSet resultado=stmt.executeQuery("SELECT ID FROM ");          
        while(resultado.next()){        
            resultado.getInt(conta);
            conta++;
        }
    }
    
    
}
