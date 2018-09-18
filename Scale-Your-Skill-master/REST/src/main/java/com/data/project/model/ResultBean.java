package com.data.project.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

public class ResultBean {
	
	private String took;
	private String timed_out;
	private JSONArray _shards;
	private JSONArray hits;
	public String getTook() {
		return took;
	}
	public void setTook(String took) {
		this.took = took;
	}
	public String getTimed_out() {
		return timed_out;
	}
	public void setTimed_out(String timed_out) {
		this.timed_out = timed_out;
	}
	public JSONArray get_shards() {
		return _shards;
	}
	public void set_shards(JSONArray _shards) {
		this._shards = _shards;
	}
	public JSONArray getHits() {
		return hits;
	}
	public void setHits(JSONArray hits) {
		this.hits = hits;
	}

	
	

}
