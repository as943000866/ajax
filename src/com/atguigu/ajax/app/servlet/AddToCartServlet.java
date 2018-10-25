package com.atguigu.ajax.app.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.ajax.app.beans.ShoppingCart;
import com.atguigu.ajax.app.beans.ShoppingCartItem;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. ��ȡ�������:id, price
		String bookName = request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		
		//2. ��ȡ���ﳵ����
		HttpSession session = request.getSession();
		ShoppingCart sc = (ShoppingCart) session.getAttribute("sc");
		
		if(sc == null){
			sc = new ShoppingCart();
			session.setAttribute("sc", sc);
		}
		
		//3.�ѵ��������뵽���ﳵ��
		sc.addToCart(bookName, price);
		
		//4.׼����Ӧ�� JSON ���� {"bookName":"","totalBookNumber":1,"totalMoney":1}
		/*StringBuilder result = new StringBuilder();
		result.append("{")
			  .append("\"bookName\":\"" + bookName + "\"")
			  .append(",")
			  .append("\"totalBookNumber\":" + sc.getTotalBookNumber())
			  .append(",")
			  .append("\"totalMoney\":" + sc.getTotalMoney())
			  .append("}");*/
		
		ObjectMapper mapper = new ObjectMapper();
		//5.��Ӧ JSON ����
		response.setContentType("text/javascript");
		response.getWriter().print(mapper.writeValueAsString(sc));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
