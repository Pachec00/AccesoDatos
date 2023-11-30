package Prueba.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Prueba.modelo.Agenda;

@RestController
public class AgendaService {
	
	private Agenda agenda;

	@GetMapping("/showList")
	public Agenda getAgenda(@RequestParam String nombre) { // Mostrar todo el TO-DO LIST
		
		List<Agenda> lista = agenda.getListaAgenda();
		
		for (int i = 0; i < lista.size(); i++) {
			agenda = lista.get(i);
			if(agenda.getTitulo().equals(nombre)) {
				return agenda;
			}
		}
		return null;
	}
	
	@PostMapping("/newAgenda")
	public Agenda newAgenda(@RequestBody Agenda a){
		System.out.println("Agenda creada");
		List<Agenda> nueva = agenda.getListaAgenda();
		nueva.add(a);
		return a;
	}
}
