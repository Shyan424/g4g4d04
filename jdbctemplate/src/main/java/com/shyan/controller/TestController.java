package com.shyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shyan.jdbctemplate.NamedParameterJdbcTemplateExample;

@RestController
public class TestController {
	
	@Autowired
	NamedParameterJdbcTemplateExample example;
	
	@RequestMapping("/changeTable/{aa}")
	public String changeTable(@PathVariable String aa) {
		
		return example.changeTable(aa);
	}
}
