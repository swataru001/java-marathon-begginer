package jp.co.rakus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Calc")
public class Calc {

	@Autowired
	private HttpSession session;

	@RequestMapping("/index")
	public String index() {
		
		return "inputvalue";
	}

	@RequestMapping("/calcExecute")
	public String calcExecute(String num1, String num2) {
		int num01 = Integer.parseInt(num1);
		int num02 = Integer.parseInt(num2);
		int result = num01 * num02;

		session.setAttribute("num1", num01);
		session.setAttribute("num2", num02);
		session.setAttribute("result", result);

		return "outputvalue";
	}

	@RequestMapping("/output2")
	public String output2() {
		return "outputvalue2";
	}
}
