package com.github.dandelion.datatables.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.dandelion.datatables.model.Person;
import com.github.dandelion.datatables.service.PersonService;

/**
 * TODO
 * 
 * @author Thibault Duchateau
 */
@Controller
@RequestMapping(method = RequestMethod.GET)
public class DemoController {

	@Autowired
	private PersonService personService;

	/**
	 * <p>
	 * This model attribute populates all the tables that use client-side
	 * processing, i.e. all DOM examples and also AJAX source.
	 * 
	 * @return the entire set of persons.
	 */
	@ModelAttribute("persons")
	public List<Person> populateTable() {
		return personService.findLimited(100);
	}

	@RequestMapping(value = "/bootstrap2/{page}")
	public String goToBootstrap2Example(@PathVariable String page) {
		return "bootstrap2." + page;
	}
	
	@RequestMapping(value = "/jqueryui/{page}")
	public String goToBasicJqueryuiExample(@PathVariable String page) {
		return "jqueryui." + page;
	}
}