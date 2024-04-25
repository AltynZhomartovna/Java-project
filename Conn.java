/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.sql.*;

public class Conn{

    Connection c;
    Statement s;
    public Conn(){
        try{

            c =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/travell","root","170405a");

            s =c.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}  