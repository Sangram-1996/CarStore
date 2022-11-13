package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.controller.AdminController;
import com.demo.model.Car;
import com.demo.model.Details;
import com.demo.model.Location;
import com.demo.model.Manufacturer;
import com.demo.service.CarsService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = AdminController.class)
public class CarStoreApplicationUnitTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarsService carsService;
	
	@Test
	public void postCarTest() throws Exception {
		
		
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
		
		
		
		Mockito.when(carsService.addNewCar(car, null)).thenReturn(car);
		MockHttpServletRequestBuilder reqbuilder=MockMvcRequestBuilders.post("/cars");
		
		ResultActions perform=mockMvc.perform(reqbuilder);
		
		MvcResult mvcresult= perform.andReturn();
		MockHttpServletResponse respons=mvcresult.getResponse();
		
		assertEquals(201, respons.getStatus());
		
	}
	
	
	@Test
	public void putCarTest() {
		
		
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
		car.setPrice(280000);
		car.setLocation(new Location(12.23,12.34));
		
		
		Mockito.when(carsService.updateCarPrice(1, 280000,"786143").thenReturn(car);
		MockHttpServletRequestBuilder reqbuilder=MockMvcRequestBuilders.post("/cars");
		
		ResultActions perform=mockMvc.perform(reqbuilder);
		
		MvcResult mvcresult= perform.andReturn();
		MockHttpServletResponse respons=mvcresult.getResponse();
		
		assertEquals(201, respons.getStatus());
	}
	
	@Test
	public void getCarTest() {
		
		
		Car car=new Car();
		
		Details detail=new Details();
		detail.setCardetailId(2);
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
		

		car.setCarId(1);
		car.setCarCondition("USED");
		car.setDetails(detail);
		car.setPrice(280000);
		car.setLocation(new Location(12.23,12.34));
		
		
		Mockito.when(carsService.getCarbyId(1, "786143").thenReturn(car);
		MockHttpServletRequestBuilder reqbuilder=MockMvcRequestBuilders.post("/cars");
		
		ResultActions perform=mockMvc.perform(reqbuilder);
		
		MvcResult mvcresult= perform.andReturn();
		MockHttpServletResponse respons=mvcresult.getResponse();
		
		assertEquals(200, respons.getStatus());
	}
	
	
	@Test
	public void deleteCarTest() {
		
		
		Car car=new Car();
		
		Details detail=new Details();
		detail.setCardetailId(2);
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
		

		car.setCarId(1);
		car.setCarCondition("USED");
		car.setDetails(detail);
		car.setPrice(280000);
		car.setLocation(new Location(12.23,12.34));
		
		
		Mockito.when(carsService.getCarbyId(1, "786143").thenReturn(car);
		MockHttpServletRequestBuilder reqbuilder=MockMvcRequestBuilders.post("/cars");
		
		ResultActions perform=mockMvc.perform(reqbuilder);
		
		MvcResult mvcresult= perform.andReturn();
		MockHttpServletResponse respons=mvcresult.getResponse();
		
		assertEquals(200, respons.getStatus());
	}
	
}
