package com.DAO.TIENDALICORES;
 import java.sql.*;
public class conexion {
	//Parametros de conexion
	String bd ="DB_TiendadeLicores";
	String Login="root";
	String password="Admin_2021";
	String url="jdbc:mysql://localhost/"+bd;
	
	Connection con= null;
	//constructor de conexion
	public conexion()
	{
		try
		{
			//obtener el driver para MySQL
			Class.forName("com.mysql.jdbc.Driver");
			//obtener la conexion
		    con = DriverManager.getConnection(url,Login,password);
		    if(con !=null)
		    	System.out.println("Conexion a la base de datos: "+bd+"exitosa");
		}
		catch(SQLException e)
		{
			System.out.println("error de conexion: "+ e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("error de conexion: "+ e);
		}
		catch(Exception e)
		{
			System.out.println("error de conexion: "+ e);
		}
	}
	
	//Metodo para retornar la conexion
	public Connection getCon()
	{
		return con;
	}
	//Metodo para desconectar
	public void desconectar()
	{
		con=null;
	}
}
