package prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import prueba.clienteRest.clientRest;
import prueba.modelo.Deporte;

@SpringBootApplication
@EnableAutoConfiguration
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
		
		
//		Deporte deporte2 = client.crearDeporte(deporte);
//		System.out.println("Deporte creado: "+ deporte2);
	}

}
