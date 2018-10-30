package jp.co.rakus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CalcTax")
public class CalcTax {

	@Autowired
	private HttpSession session;

	@RequestMapping("/index")
	public String index() {

		return "input";
	}

	@RequestMapping("/calcExecute")
	public String calcExecute(String price1, String price2, String price3) {
		final double TAX = 0.08;
		int price01 = Integer.parseInt(price1);
		int price02 = Integer.parseInt(price2);
		int price03 = Integer.parseInt(price3);
		
		int totalPrice = price01 + price02 + price03;
		
		int tatalPriceIncludeTax = (int) (totalPrice * TAX);

		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("tatalPriceIncludeTax", tatalPriceIncludeTax);;

		return "output";
	}

}
