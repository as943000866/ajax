package com.atguigu.ajax.app.test;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Customer {
	
	private String name;
	private String id;
	
	
	
	public Customer(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getcustomerName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCity(){
		return "BeiJing";
	}
	@JsonIgnore
	public String getBirth(){
		return "1990-12-12";
	}
	
	
	public static void main(String[] args) throws JsonProcessingException {
		//1. 导入 jar 包
		//2. 创建 ObjectMapper 对象
		ObjectMapper mapper = new ObjectMapper();
		
		//3. 调用 mapper 的 writeValueAsString() 方法把一个对象转为一个 JSON 字符串
		Customer customer = new Customer("AtGuigu","1001");
		
		String jsonStr = mapper.writeValueAsString(customer);
		System.out.println(jsonStr);
		
		//4. 注意: JackSon 使用 getter 方法来定位 JSON 对象的属性
		//5. 可以通过添加注解 com.fasterxml.jackson.annotation.JsonIgnore
		//忽略某一个 getter 定义的属性
		
		List<Customer> customers = Arrays.asList(customer, new Customer("BCD","2002"));
		jsonStr = mapper.writeValueAsString(customers);
		
		System.out.println(jsonStr);
		
	}
}
