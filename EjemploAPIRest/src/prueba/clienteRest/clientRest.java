package prueba.clienteRest;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import prueba.modelo.Deporte;

public class clientRest {

	private String urlBase;
	private RestTemplate restTemplate;
	
	public clientRest(String urlBase, Integer msTimeout)  {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(msTimeout);
		this.restTemplate = new RestTemplate(requestFactory);
	}
	
	public Deporte getDeporte(Integer id) {
		String url = urlBase + "/deporte?id=" + id;
		Deporte d = restTemplate.getForObject(url, Deporte.class, id);
		return d;
	}
	
	public Deporte crearDeporte(Deporte deporte) {
		String url = urlBase + "/deporte";
		Deporte d = restTemplate.postForObject(url, deporte, Deporte.class);
		return d;
	}
}
