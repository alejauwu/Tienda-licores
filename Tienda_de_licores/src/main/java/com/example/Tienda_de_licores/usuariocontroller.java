package com.example.Tienda_de_licores;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TIENDALICORES.usuarioDAO;
import com.DTO.tiendalicores.usuarios;

@RestController


public class usuariocontroller {
	
	@RequestMapping("/listausuarios")
	public ArrayList<usuarios> listaUsuarios()
	{
		usuarioDAO Dao = new usuarioDAO();
		return Dao.listaUsuarios();
	}
	@RequestMapping("/consultarusuario")
	public ArrayList<usuarios> consultarusuario(int documento)
	{
		usuarioDAO Dao = new usuarioDAO();
		return Dao.consultarusuario(documento);			
	}
	@RequestMapping("/registrarusuario")
	public void registrarusuario(usuarios persona)
	{
		usuarioDAO Dao = new usuarioDAO();
		Dao.registrarusuario(persona);
	}
	@RequestMapping("/eliminarusuario")
	public void eliminararusuario(int documento)
	{
		usuarioDAO Dao = new usuarioDAO();
		Dao.eliminarusuario(documento);
	}
	
	@RequestMapping("/actualizarusuario")
	public void actualizarusuario(int documento, String nombre, String correo)
	{
		usuarioDAO Dao = new usuarioDAO();
		Dao.actualizarusuario(documento,nombre,correo);
	}
	
	
	

}
