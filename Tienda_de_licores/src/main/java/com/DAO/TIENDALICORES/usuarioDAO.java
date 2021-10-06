package com.DAO.TIENDALICORES;
import java.sql.*;
import java.util.ArrayList;
//esta clase permite ecceso a la base de datos

import com.DTO.tiendalicores.usuarios;

public class usuarioDAO {
	//metodo para consultar los usuarios
	public ArrayList<usuarios> listaUsuarios()
	{
		ArrayList<usuarios> miLista = new ArrayList<usuarios>();
		conexion con = new conexion();
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_Usuarios");
			ResultSet rs = consulta.executeQuery();
			while(rs.next())
			{
				usuarios persona = new usuarios();
				persona.setCedula(Integer.parseInt(null, rs.getShort("cedula_usu")));
				persona.setNombre(rs.getString("nombre_usu"));
				persona.setCorreo(rs.getNString("correo_usu"));
				persona.setUsuario(rs.getString("usuario"));
				persona.setClave(rs.getString("clave"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
			
		}
		catch(Exception e)
		{
			System.out.println("error de conexion: "+ e);
		}
		return miLista;
	}
   public ArrayList<usuarios> consultarusuario(int documento)
   {
	   ArrayList<usuarios> miLista = new ArrayList<usuarios>();
	   conexion con = new conexion();
	try 
	{
		PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_Usuarios WHERE cedula_usu=?");
		consulta.setInt(1, documento);
		ResultSet rs = consulta.executeQuery();
		if(rs.next())
		{
			usuarios persona = new usuarios();
			persona.setCedula(Integer.parseInt(rs.getString("cedula_usu")));
			persona.setNombre(rs.getString("nombre_usu"));
			persona.setCorreo(rs.getString("correo_usu"));
			persona.setUsuario(rs.getString("usuario"));
			persona.setClave(rs.getString("clave_usu"));
			
			miLista.add(persona);
		}
		rs.close();
		consulta.close();
		con.desconectar();
		
			}
	catch(Exception e)
	{
		System.out.println("error de conexion: "+ e);
	}
	return miLista;
			
		}
   public void registrarusuario(usuarios persona)
   {
	   conexion con = new conexion();
	   try
	   {
		   Statement stmt = con.getCon().createStatement();
		   stmt.executeUpdate("INSERT INTO T_USUARIOS values(' "+persona.getCedula()+"','"+
				   persona.getNombre()+"','"+persona.getCorreo()+"','"+persona.getUsuario()+"','"+
				   persona.getClave()+"')");
		   
		   System.out.println("El usuario ha sido adicionado ");
		   con.desconectar();
	   }
	   catch(Exception e)
	   {
		   System.out.println("error de conexion: "+ e);
		   
	   }
	   
   }
   public void eliminarusuario(int documento)
   {
	   conexion con = new conexion();
	try 
	{
		PreparedStatement consulta = con.getCon().prepareStatement("DELETE FROM T_Usuarios WHERE cedula_usu=?");
		consulta.setInt(1, documento);
		consulta.executeUpdate();
		System.out.println("El usuario ha sido eliminado");
		
		consulta.close();
		con.desconectar();
		
	}
	catch(Exception e)
	{
		System.out.println("error de conexion: "+ e);
	}
			
		}
   
   public void actualizarusuario(int documento,String nombre,String correo)
   {
	   conexion con = new conexion();
	try 
	{
		PreparedStatement consulta = con.getCon().prepareStatement("UPDATE T_USUARIOS SET nombre_usu=?,correo_usu=? WHERE cedula_usu=?");
		consulta.setString(1, nombre);
		consulta.setString(1, correo);
		consulta.setInt(1, documento);
		consulta.executeUpdate();
		System.out.println("El usuario ha sido actualizado");
		
		consulta.close();
		con.desconectar();
		
	}
	catch(Exception e)
	{
		System.out.println("error de conexion: "+ e);
	}
	
		}
	
	
}
