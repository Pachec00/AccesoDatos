package clients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import modelo.Ciudad;


public class CiudadesClientImpl implements CiudadesClient {

	private String urlBase;
	private RestTemplate restTemplate;

	public CiudadesClientImpl(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectionRequestTimeout(msTimeout);
		this.restTemplate = new RestTemplate(requestFactory);
	}

	@Override
	public List<Ciudad> getCities(String filtroDescripcion) throws CiudadNoEncontradaException, CiudadErrorException {
		String url = urlBase + "/city?filtroDescripcion=" + filtroDescripcion;
		Ciudad[] c = restTemplate.getForObject(url, Ciudad[].class);
		List<Ciudad> ciudades = new ArrayList<>();
		return Arrays.asList(c);
	}

	@Override
	public Ciudad getCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {
		String url = urlBase + "/city/" + id;
		Ciudad c = restTemplate.getForObject(url, Ciudad.class, id);
		return c;
	}

	@Override
	public Ciudad createCity(Ciudad city) throws CiudadErrorException {
		String url = urlBase + "/city";
		Ciudad c = restTemplate.postForObject(url, city, Ciudad.class);
		return c;

	}

	@Override
	public void updateCity(Ciudad city) throws CiudadNoEncontradaException, CiudadErrorException {
		String url = urlBase + "/city";
		restTemplate.put(url, city);
	}

	@Override
	public Ciudad updateSelectiveCity(Ciudad city) throws CiudadNoEncontradaException, CiudadErrorException {
		return null;
	}

	@Override
	public void deleteCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {
		String url = urlBase + "/city/{id}";
		restTemplate.delete(url,id);
		
	}

}
