package prueba.clienteRest;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import prueba.modelo.Persona;

public class ClientRest {

	private String urlBase;
	private RestTemplate restTemplate;

	public ClientRest(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(msTimeout);
		this.restTemplate = new RestTemplate(requestFactory);
	}

	public Persona getPersona(Integer id) {
		String url = urlBase + "/persona?id=" + id;
		Persona p = restTemplate.getForObject(url, Persona.class, id);
		return p;
	}
}