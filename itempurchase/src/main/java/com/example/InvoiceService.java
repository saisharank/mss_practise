package com.example;

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
public class InvoiceService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	

	public Map<String, String> insertItems(Item item) {

		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "INSERT INTO item (item_name,available_quantity,pop) VALUES (:item_name,:available_quantity,:pop)";
		try
		{
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("item_name", item.getItem_name())
					.addValue("available_quantity",item.getAvailable_quantity())
					.addValue("pop", item.getPop());

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
	public Map<String, String> itemupdate(Item item) {
		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "update item set pop=? where item_id=?";
		try {
			result = jdbcTemplate.update(sql,item.getPop(),item.getItem_id());
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

	

	public List itemget(int itemid) {
		
		Map dataMap = new HashMap();
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select item_id,item_name,available_quantity from item where item_id = ?";
		try {
			dataList = jdbcTemplate.queryForList(sql, itemid);

			for (Map<String, Object> row : dataList) {
				dataMap.put("item_id", row.get("item_id"));
				dataMap.put("item_name", row.get("item_name"));
				dataMap.put("available_quantity", row.get("description"));
				responseList.add(dataList);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");
		}
		
		return responseList;
	}

	public List itemgetAll() {
		
		Map dataMap = null;
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select * from item";

		try {
			dataList = jdbcTemplate.queryForList(sql);

			for (Map<String, Object> row : dataList) {
				dataMap = new HashMap();
				dataMap.put("item_id", row.get("item_id"));
				dataMap.put("item_name", row.get("item_name"));
				dataMap.put("available_quantity", row.get("description"));
				dataMap.put("pop", row.get("pop"));
				responseList.add(dataMap);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");

		}
		
		return responseList;
	}
	
public Map<String, String> insertCustomers(Customer customer) {

		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "insert into customer (customer_name,phonenumber,address,city,state,zip,username,password) VALUES (:customer_name,:phonenumber,:address,:city,:state,:zip,:username,:password)";
		try
		{
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("customer_name", customer.getCustomer_name())
					.addValue("phonenumber",customer.getPhonenumber())
					.addValue("address", customer.getAddress())
					.addValue("city", customer.getCity())
					.addValue("state", customer.getState())
					.addValue("zip", customer.getZip())
					.addValue("username", customer.getUsername())
					.addValue("password", customer.getPassword());

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
	public Map<String, String> updateCustomer(Customer customer) {
		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "update customer set phonenumber=? where customer_id=?";
		try {
			result = jdbcTemplate.update(sql,customer.getPhonenumber(),customer.getCustomer_id());
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

	

	public List getCustomer(int customerid) {
		
		Map dataMap = new HashMap();
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select customer_id,customer_name,phonenumber,city,state from customer where customer_id = ?";
		try {
			dataList = jdbcTemplate.queryForList(sql, customerid);
			
			for (Map<String, Object> row : dataList)
			{
				dataMap.put("customer_id", row.get("customer_id"));
				dataMap.put("customer_name", row.get("customer_name"));
				dataMap.put("phonenumber", row.get("phonenumber"));
				dataMap.put("city", row.get("city"));
				dataMap.put("state", row.get("state"));
				responseList.add(dataMap);
				System.out.println(dataMap);
				System.out.println(responseList);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");
		}
		
		return responseList;
	}

	public List getAllcustomer() {
		
		Map dataMap = null;
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select * from customer";

		try {
			dataList = jdbcTemplate.queryForList(sql);

			for (Map<String, Object> row : dataList) {
				dataMap = new HashMap();
				dataMap.put("customer_id", row.get("customer_id"));
				dataMap.put("customer_name", row.get("customer_name"));
				dataMap.put("phonenumber", row.get("phonenumber"));
				dataMap.put("address", row.get("address"));
				dataMap.put("city", row.get("city"));
				dataMap.put("state", row.get("state"));
				dataMap.put("zip", row.get("zip"));
				dataMap.put("username", row.get("username"));
				dataMap.put("password", row.get("password"));
				responseList.add(dataMap);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");

		}
		
		return responseList;
	}
public Map<String, String> insertInvoice(Invoice invoice) {

		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "INSERT INTO invoice (item_id,customer_id,ordered_quantity) VALUES (:item_id,:customer_id,:ordered_quantity)";
		String select = "Select pop from item where itemid = ?";
		List<Map<String, Object>> nested_data = new ArrayList<Map<String, Object>>();
		nested_data = jdbcTemplate.queryForList(select,invoice.getItem_id());
		int k = (int)nested_data.get(0).get("pop");
		try
		{
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("item_id",invoice.getItem_id())
					.addValue("item_name",invoice.getItem_name())
					.addValue("customer_id",invoice.getCustomer_id())
					.addValue("customer_name",invoice.getCustomer_name())
					.addValue("ordered_quantity",invoice.getOrdered_quantity())
					.addValue("total_price",invoice.getOrdered_quantity()*k);

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
	public List invoicegetitem(int itemid) {
	
	Map dataMap = new HashMap();
	List responseList = new ArrayList();
	List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
	String sql = "select invoice_id,invoice_on,item_id,item_name,ordered_quantity from invoice where item_id = ?";
	try {
		dataList = jdbcTemplate.queryForList(sql, itemid);
		
		for (Map<String, Object> row : dataList)
		{
			dataMap.put("invoice_id", row.get("invoice_id"));
			dataMap.put("invoice_on", row.get("invoice_on"));
			dataMap.put("item_id", row.get("item_id"));
			dataMap.put("ordered_quantity", row.get("ordered_quantity"));
			responseList.add(dataMap);
			System.out.println(dataMap);
			System.out.println(responseList);
		}

	} catch (Exception e) {
		dataMap.put("error", "Error occured");
	}
	
	return responseList;
	}
	
	public List invoicegetcustomer(int customerid) {
		
	Map dataMap = new HashMap();
	List responseList = new ArrayList();
	List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
	String sql = "select invoice_id,invoice_on,item_id,customer_id,total_price from invoice where customer_id = ?";
	try {
		dataList = jdbcTemplate.queryForList(sql, customerid);
		
		for (Map<String, Object> row : dataList)
		{
			dataMap.put("invoice_id", row.get("invoice_id"));
			dataMap.put("invoice_on", row.get("invoice_on"));
			dataMap.put("customer_id", row.get("customer_id"));
			dataMap.put("item_id", row.get("item_id"));
			dataMap.put("total_price", row.get("total_price"));
			responseList.add(dataMap);
			System.out.println(dataMap);
			System.out.println(responseList);
		}

	} catch (Exception e) {
		dataMap.put("error", "Error occured");
	}
	
	return responseList;
	}
	
public List invoicegetall() {
		
		Map dataMap = null;
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select * from invoice";

		try {
			dataList = jdbcTemplate.queryForList(sql);

			for (Map<String, Object> row : dataList) {
				dataMap = new HashMap();
				dataMap.put("invoice_id", row.get("invoice_id"));
				dataMap.put("invoice_on", row.get("invoice_on"));
				dataMap.put("item_id", row.get("item_id"));
				dataMap.put("item_name", row.get("item_name"));
				dataMap.put("customer_id", row.get("customer_id"));
				dataMap.put("customer_name", row.get("customer_name"));
				dataMap.put("ordered_quantity", row.get("ordered_quantity"));
				dataMap.put("total_price", row.get("total_price"));
				responseList.add(dataMap);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");

		}
		return responseList;
	}
}