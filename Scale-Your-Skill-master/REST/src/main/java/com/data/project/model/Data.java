package com.data.project.model;

import java.util.ArrayList;
import java.util.List;

public class Data {
	
	List<String> skills = new ArrayList<>();

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Data [skills=" + skills + "]";
	}
	
	

}
