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
		//1. 获取请求参数:id, price
		String bookName = request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		
		//2. 获取购物车对象
		HttpSession session = request.getSession();
		ShoppingCart sc = (ShoppingCart) session.getAttribute("sc");
		
		if(sc == null){
			sc = new ShoppingCart();
			session.setAttribute("sc", sc);
		}
		
		//3.把点击的项加入到购物车中
		sc.addToCart(bookName, price);
		
		//4.准备响应的 JSON 对象 {"bookName":"","totalBookNumber":1,"totalMoney":1}
		/*StringBuilder result = new StringBuilder();
		result.append("{")
			  .append("\"bookName\":\"" + bookName + "\"")
			  .append(",")
			  .append("\"totalBookNumber\":" + sc.getTotalBookNumber())
			  .append(",")
			  .append("\"totalMoney\":" + sc.getTotalMoney())
			  .append("}");*/
		
		ObjectMapper mapper = new ObjectMapper();
		//5.响应 JSON 对象
		response.setContentType("text/javascript");
		response.getWriter().print(mapper.writeValueAsString(sc));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
