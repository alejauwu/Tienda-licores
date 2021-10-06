package com.example.Tienda_de_licores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DAO.TIENDALICORES.conexion;

@SpringBootApplication
public class TiendaDeLicoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaDeLicoresApplication.class, args);
		//conexion conn= new conexion();
		//conn.getCon();
	}

}
