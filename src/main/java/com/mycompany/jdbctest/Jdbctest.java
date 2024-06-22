/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorei
 */
public class Jdbctest {

    public static void main(String[] args) {
         String usuario="root";
         String password="";
         String url="jdbc:mysql://localhost:3306/jdbctest";
         Connection conexion;
         Statement statement;
         ResultSet rs;
         
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement =conexion.createStatement ();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //Insercion de datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'LorenaEsteban');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //Actualizacion de los datos
            statement.execute("UPDATE `usuarios` SET `nombre` = 'LorenitaGutierrez' WHERE `usuarios`.`id` = 3;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //Eliminar los datos
            statement.execute("FROM usuarios WHERE `usuarios`.`id` = 2\"");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Jdbctest.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         
    }
}
