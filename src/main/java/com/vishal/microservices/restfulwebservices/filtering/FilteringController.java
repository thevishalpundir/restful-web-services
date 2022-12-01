package com.vishal.microservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1",
				"field3");
		FilterProvider filter = new SimpleFilterProvider().addFilter("someBeanFilter", simpleBeanPropertyFilter);
		mappingJacksonValue.setFilters(filter);
		return mappingJacksonValue;
	}

	@GetMapping("/filtering/list")
	public MappingJacksonValue filteringList() {
		List<SomeBean> beans = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value4", "value4", "value6"), new SomeBean("value7", "value8", "value9"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(beans);

		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filter = new SimpleFilterProvider().addFilter("someBeanFilter", simpleBeanPropertyFilter);
		mappingJacksonValue.setFilters(filter);

		return mappingJacksonValue;

	}
}
