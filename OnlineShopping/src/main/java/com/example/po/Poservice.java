package com.example.po;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class Poservice {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Map<String, String> insertPo(Po po) {

		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "INSERT INTO po (customerid,podate,pototal,poshiptoaddress,poshiptozip,poshiptocity,poshiptostate,"
				+ "pobilltoaddress,pobilltozip,pobilltocity,pobilltostate,postatus) VALUES (:customerid,:podate,:pototal,:poshiptoaddress,"
				+ ":poshiptozip,:poshiptocity,:poshiptostate,:pobilltoaddress,:pobilltozip,:pobilltocity,:pobilltostate,:postatus)";
		try
		{
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("customerid", po.getCustomerid())
					.addValue("podate", po.getPodate())
					.addValue("pototal", po.getPototal())
					.addValue("poshiptoaddress", po.getPoshiptoaddress())
					.addValue("poshiptozip", po.getPoshiptozip())
					.addValue("poshiptocity", po.getPoshiptocity())
					.addValue("poshiptostate", po.getPoshiptostate())
					.addValue("pobilltoaddress", po.getPobilltoaddress())
					.addValue("pobilltozip", po.getPobilltozip())
					.addValue("pobilltocity", po.getPobilltocity())
					.addValue("pobilltostate", po.getPobilltostate())
					.addValue("postatus", po.getPostatus());

			result = namedParameterJdbcTemplate.update(sql, parameters);
			if (result > 0)
				data.put("success", "Record inserted successfully");
			else
				data.put("failed", "Record failed to insert, please try again!");
		} catch (Exception e) {
			data.put("error", "Error occured, please try again!");
			
		}
		
		return data;

	}
	public Map<String, String> update(Po po) {
		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "update po set postatus=? where poid=?";
		try {
			result = jdbcTemplate.update(sql,po.getPostatus(),po.getPoid());
			if (result > 0)
				data.put("success", "updated successfully");
			else
				data.put("failed", "updation failed");
		} catch (Exception e) {
			data.put("error", "Error occured, please try again!");
	e.printStackTrace();
		}
		
		return data;
	}

	

	public List get(int id) {
		
		Map dataMap = new HashMap();
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select poid,customerid,podate,pototal,postatus from po where poid = ?";
		try {
			dataList = jdbcTemplate.queryForList(sql, id);

			for (Map<String, Object> row : dataList) {
				dataMap.put("poid", row.get("poid"));
				dataMap.put("customerid", row.get("customerid"));
				dataMap.put("podate", row.get("podate"));
				dataMap.put("pototal", row.get("pototal"));
				dataMap.put("postatus", row.get("postatus"));
				responseList.add(dataList);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");
		}
		
		return responseList;
	}

	public List getAll() {
		
		Map dataMap = null;
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select * from po";

		try {
			dataList = jdbcTemplate.queryForList(sql);

			for (Map<String, Object> row : dataList) {
				dataMap = new HashMap();
				dataMap.put("poid", row.get("poid"));
				dataMap.put("customerid", row.get("customerid"));
				dataMap.put("podate", row.get("podate"));
				dataMap.put("pototal", row.get("pototal"));
				dataMap.put("poshiptoaddress", row.get("poshiptoaddress"));
				dataMap.put("poshiptozip", row.get("poshiptozip"));
				dataMap.put("poshiptocity", row.get("poshiptocity"));
				dataMap.put("poshiptostate", row.get("poshiptostate"));
				dataMap.put("pobilltoaddress", row.get("pobilltoaddress"));
				dataMap.put("pobilltozip", row.get("pobilltozip"));
				dataMap.put("pobilltocity", row.get("pobilltocity"));
				dataMap.put("pobilltostate", row.get("pobilltostate"));
				dataMap.put("postatus", row.get("postatus"));
				responseList.add(dataMap);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");

		}
		
		return responseList;
	}

}