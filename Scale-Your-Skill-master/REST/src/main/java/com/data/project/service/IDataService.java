package com.data.project.service;

import java.util.List;

public interface IDataService {

	public List<String> getJobStatistics(List<String> skills);
	public int getTotalJob();
	
}
