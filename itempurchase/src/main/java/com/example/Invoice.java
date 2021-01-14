package com.example;

public class Invoice {
	private int invoice_id;
	private String invoice_on;
	private int item_id;
	private int item_name;
	private int customer_id;
	private String customer_name;
	private int ordered_quantity;
	private int total_price;
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public String getInvoice_on() {
		return invoice_on;
	}
	public void setInvoice_on(String invoice_on) {
		this.invoice_on = invoice_on;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItem_name() {
		return item_name;
	}
	public void setItem_name(int item_name) {
		this.item_name = item_name;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getOrdered_quantity() {
		return ordered_quantity;
	}
	public void setOrdered_quantity(int ordered_quantity) {
		this.ordered_quantity = ordered_quantity;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

}
