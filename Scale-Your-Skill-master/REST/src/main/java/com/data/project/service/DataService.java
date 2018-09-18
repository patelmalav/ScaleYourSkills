package com.data.project.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataService implements IDataService {

	@Override
	public List<String> getJobStatistics(List<String> skills) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		List<String> skillTotal = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.#######");
		df.setRoundingMode(RoundingMode.CEILING);
		StringBuilder sb = new StringBuilder();
		for (String s : skills) {
			sb.append(" ");
			sb.append(s);
		}

		String url = "http://ec2-52-15-142-28.us-east-2.compute.amazonaws.com:9200/feature/_search";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String jsonString = new JSONObject()
				.put("query", new JSONObject().put("match", new JSONObject().put("feature", sb))).toString();
		HttpEntity<String> entity = new HttpEntity<String>(jsonString, headers);
		String result = restTemplate.postForObject(url, entity, String.class);
		JSONObject jsonObj = new JSONObject(result);
		Iterator<String> keys = jsonObj.keys();
		while (keys.hasNext()) {
			String key = keys.next(); // First key in your json object
			if (key.equals("hits")) {
				JSONObject j = (JSONObject) jsonObj.get(key);
				Iterator<String> jkeys = j.keys();
				while (jkeys.hasNext()) {
					String jkey = jkeys.next();
					if (jkey.equals("total")) {
						int totalJob = getTotalJob();
						int total = Integer.parseInt(j.get(jkey).toString());
						double probability = (Double.parseDouble(String.valueOf(total)) / Double.parseDouble(String.valueOf(totalJob))) * 100;
						
						skillTotal.add(df.format(probability));
					}
				}

			}
		}
	

		return skillTotal;
	}

	@Override
	public int getTotalJob() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		int totalJob = 0;
		String url = "http://ec2-52-15-142-28.us-east-2.compute.amazonaws.com:9200/feature/_search";
		String result = restTemplate.getForObject(url, String.class);
		JSONObject jsonObj = new JSONObject(result);
		Iterator<String> keys = jsonObj.keys();
		while (keys.hasNext()) {
			String key = keys.next(); // First key in your json object
			if (key.equals("hits")) {
				JSONObject j = (JSONObject) jsonObj.get(key);
				Iterator<String> jkeys = j.keys();
				while (jkeys.hasNext()) {
					String jkey = jkeys.next();
					if (jkey.equals("total")) {
						totalJob = Integer.parseInt(j.get(jkey).toString());
					}
				}

			}
		}

		return totalJob;
	}

}
