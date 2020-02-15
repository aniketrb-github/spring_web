package com.arbtech.zrestws.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

	/**
	 * Here, we performed the REST WS versioning via Path Params by 
	 * mentioning /v1 and /v2
	 * 
	 * API: http://localhost:8888/person/v1/1
	 */
	@GetMapping(value = "/v1/{personId}")
	public PersonV1 getPersonV1()	{
		return new PersonV1("Vijay Chouhan");
	}
	
	/**
	 * API: http://localhost:8888/person/v2/1 
	 */
	@GetMapping(value = "/v2/{personId}")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Rajesh", "Ranjan"));
	}
	
	// -----------------------------------------------------------------------
	
	/**
	 * Here, we performed versioning via the request headers
	 * We added header support for our end-points as X-API-VERSION=1 and X-API-VERSION=2
	 * 
	 * API: http://localhost:8888/person/header
	 * and also you need to pass the header KEY as 'X-API-VERSION' and VALUE as '1' in the Headers section
	 */
	@GetMapping(value = "/header", headers = "X-API-VERSION=1")
	public PersonV1 getPersonViaRequestHeader1()	{
		return new PersonV1("Vijay Chouhan");
	}
	
	/** API: http://localhost:8888/person/header
	 * and also you need to pass the header KEY as 'X-API-VERSION' and VALUE as '2' in the Headers section
	 */
	@GetMapping(value = "/header", headers = "X-API-VERSION=2")
	public PersonV2 getPersonViaRequestHeader2() {
		return new PersonV2(new Name("Rajesh", "Ranjan"));
	}
	
	// -----------------------------------------------------------------------
	
	/**
	 * Here, we performed versioning via the request params
	 * We added params support for our end-points as version=1 and version=2
	 * 
	 * API: http://localhost:8888/person/params?version=1
	 */
	@GetMapping(value = "/params", params = "version=1")
	public PersonV1 getPersonViaParams1()	{
		return new PersonV1("Vijay Chouhan");
	}
	
	// http://localhost:8888/person/params?version=2
	@GetMapping(value = "/params", params = "version=2")
	public PersonV2 getPersonViaParams2() {
		return new PersonV2(new Name("Rajesh", "Ranjan"));
	}
	
	// -----------------------------------------------------------------------
	
	/**
	 * Here, we performed versioning via the 'produces' attribute of GetMapping
	 * We added params support for our end-points as version=1 and version=2
	 * 
	 * API: http://localhost:8888/person/produces
	 * Pass the produces KEY as 'Accept' and VALUE as 'application/arbtech.co.app.v1+json' in the Headers section
	 */
	@GetMapping(value = "/produces", produces = "application/arbtech.co.app.v1+json")
	public PersonV1 getPersonViaProduces1()	{
		return new PersonV1("Vijay Chouhan");
	}
	
	/**
	 * API: http://localhost:8888/person/produces
	 * Pass the produces KEY as 'Accept' and VALUE as 'application/arbtech.co.app.v1+json' in the Headers section
	 */
	@GetMapping(value = "/produces", produces = "application/arbtech.co.app.v2+json")
	public PersonV2 getPersonViaProduces2() {
		return new PersonV2(new Name("Rajesh", "Ranjan"));
	}
	
}
