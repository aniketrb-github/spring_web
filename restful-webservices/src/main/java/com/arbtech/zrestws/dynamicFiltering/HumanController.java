package com.arbtech.zrestws.dynamicFiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/human")
public class HumanController {
	
	@GetMapping(value = "/{humanId}")
	public MappingJacksonValue getHuman(@PathVariable String humanId) {
		Human human = new Human("Aniket", "Bharsakale", "Male", 27);
		MappingJacksonValue mapping = prepareDynamicFilter(human, "firstName", "age");
		return mapping;		
	}
	
	@GetMapping
	public MappingJacksonValue getAllHumans() {
		List<Human> humans = Arrays.asList(new Human("Ramdas", "Bharsakale", "Male", 57), new Human("Savita", "Bharsakale", "Male", 53));
		MappingJacksonValue mappingJacksonValue = prepareDynamicFilter(humans, "firstName", "lastname", "age");
		return mappingJacksonValue;
	}
	
	/**
	 * This is a re-factored optimized method which will dynamically filter the response as per client's needs
	 * This will provide an abstraction for the fields to be sent in the final response to the client.
	 * 
	 * @param object : the data that will be dynamically filtered for the requested specific end-point
	 * @param propertyArray : the list of pojo attributes that will be sent in the response to client side
	 * @return the dynamically filtered response for a particular end-point according to its requested needs 
	 */
	public static MappingJacksonValue prepareDynamicFilter(Object object, String... propertyArray) {
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(propertyArray);
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("HumanDynamicFilter", simpleBeanPropertyFilter);
		MappingJacksonValue mapping = new MappingJacksonValue(object);
		mapping.setFilters(filterProvider);
		return mapping;		
	}
}
