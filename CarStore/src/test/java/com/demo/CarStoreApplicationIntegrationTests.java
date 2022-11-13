package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.model.Car;
import com.demo.model.Details;
import com.demo.model.Location;
import com.demo.model.Manufacturer;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class CarStoreApplicationIntegrationTests {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getCarTest()throws Exception {
		
		String url= "http://localhost:"+port+"/cars/14";
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("key","786143" ).build();
				
				
	HttpEntity<String>  requestentity = new HttpEntity<String>(null, null);
	ResponseEntity<Car> response= testRestTemplate.exchange(builder.toString(), HttpMethod.GET,requestentity,Car.class);
	
	System.out.println(response);
	assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	
	
	@Test
	public void deleteCarTest()throws Exception {
		
		String url= "http://localhost:"+port+"/cars/6";
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("key","786143" ).build();
				
				
	HttpEntity<String>  requestentity = new HttpEntity<String>(null, null);
	ResponseEntity<Car> response= testRestTemplate.exchange(builder.toString(), HttpMethod.DELETE,requestentity,Car.class);
	
	System.out.println(response);
	assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	
	
	
	@Test
	public void postCarTest()throws Exception {
		
		
		Car car=new Car();
		
		Details detail=new Details();
		detail.setBody("Solid");
		detail.setModel("Mxzoo1");
		detail.setNumberOfDoors(4);
		detail.setFuelType("petrol");
		detail.setEngine("petrol");
		detail.setMileage(18.00);
		detail.setModelYear(2010);
		detail.setProductionYear(2011);
		detail.setExternalColor("black");
		detail.setManufacturer(new Manufacturer(101, "Honda"));
		

		
		car.setCarCondition("USED");
		car.setDetails(detail);
		car.setPrice(100099);
		car.setLocation(new Location(12.23,12.34));

		
		String url= "http://localhost:"+port+"/cars";
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("key","786143" ).build();
				
				
	HttpEntity<Car>  requestentity = new HttpEntity<>(car,null);
	ResponseEntity<Car> response=  testRestTemplate.exchange(builder.toString(), HttpMethod.POST,requestentity,Car.class);
	
	System.out.println(response);
	assertEquals(HttpStatus.CREATED,response.getStatusCode());
	
	}
	
	@Test
	public void putCarTest()throws Exception {
		
		String url= "http://localhost:"+port+"/cars/6/289999";
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("key","786143" ).build();
				
				
	HttpEntity<String>  requestentity = new HttpEntity<String>(null, null);
	ResponseEntity<Car> response= testRestTemplate.exchange(builder.toString(), HttpMethod.PUT,requestentity,Car.class);
	
	System.out.println(response);
	assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	
}
