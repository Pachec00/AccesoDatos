package Proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.server.ServerErrorException;

import Proyecto.service.NotFoundException;

@SpringBootApplication 
@EnableAutoConfiguration 
public class App {

	public static void main(String[] args) throws ServerErrorException, NotFoundException, Proyecto.service.ServerErrorException {
		SpringApplication.run(App.class, args); 
		
	}
}
