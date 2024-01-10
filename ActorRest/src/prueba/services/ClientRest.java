package prueba.services;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import modelo.Actor;

public class ClientRest {

	private String urlBase;
	private RestTemplate restTemplate;
	
	public ClientRest(String urlBase, Integer msTimeout)  {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(msTimeout);
		this.restTemplate = new RestTemplate(requestFactory);
	}
	
	public Actor getActor(Integer id) {
		String url = urlBase = "/actor?id=" +id;
		Actor a = restTemplate.getForObject(url, Actor.class,id);
		return a;
	}
}
