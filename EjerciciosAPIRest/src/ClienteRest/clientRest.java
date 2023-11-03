package ClienteRest;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class clientRest {

	private String urlBase;
	private RestTemplate restTemplate;
	
	public clientRest(String urlBase, Integer msTimeout)  {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(msTimeout);
		this.restTemplate = new RestTemplate(requestFactory);
	}
	
	
}
