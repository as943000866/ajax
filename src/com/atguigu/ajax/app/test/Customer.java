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
		//1. ���� jar ��
		//2. ���� ObjectMapper ����
		ObjectMapper mapper = new ObjectMapper();
		
		//3. ���� mapper �� writeValueAsString() ������һ������תΪһ�� JSON �ַ���
		Customer customer = new Customer("AtGuigu","1001");
		
		String jsonStr = mapper.writeValueAsString(customer);
		System.out.println(jsonStr);
		
		//4. ע��: JackSon ʹ�� getter ��������λ JSON ���������
		//5. ����ͨ�����ע�� com.fasterxml.jackson.annotation.JsonIgnore
		//����ĳһ�� getter ���������
		
		List<Customer> customers = Arrays.asList(customer, new Customer("BCD","2002"));
		jsonStr = mapper.writeValueAsString(customers);
		
		System.out.println(jsonStr);
		
	}
}
