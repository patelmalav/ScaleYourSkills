package com.data.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.NameList;

import com.data.project.model.Data;
import com.data.project.service.IDataService;
import com.google.gson.Gson;

@RestController
public class DataController {

	@Autowired
	IDataService serivce;
	
	@RequestMapping(value = "/getJobStatistics", method = RequestMethod.POST)
	public Double getJobStatistics(@RequestBody String skills) {
		Data data = new Gson().fromJson(skills, Data.class);
		List<String> probablity = serivce.getJobStatistics(data.getSkills());
		double finalAverage = calculateAverage(probablity);
			
		return finalAverage;
	}
	
	private double calculateAverage(List <String> probablity) {
		  Double sum = 0.0;
		  if(!probablity.isEmpty()) {
		    for (String prob : probablity) {
		        sum += Double.parseDouble(prob);
		    }
		    return sum.doubleValue() / probablity.size();
		  }
		  return sum;
		}
	
}
