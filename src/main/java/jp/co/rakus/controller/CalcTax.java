package jp.co.rakus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 入力された値を足して消費税抜きと消費税込みの値段を出力するクラス.
 * 
 * @author wataru.saito
 *
 */
@Controller
@RequestMapping("/CalcTax")
public class CalcTax {

	/**
	 * 入力画面を呼ぶメソッド.
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {

		return "input";
	}

	/**
	 * 入力された数字を足して、消費税計算をして、出力するためにリクエストスコープに格納するメソッド.
	 * 
	 * @param price1
	 *            入力値１
	 * @param price2
	 *            入力値２
	 * @param price3
	 *            入力値３
	 * @param model
	 * @return
	 */
	@RequestMapping("/calcTaxExecute")
	public String calcTaxExecute(String price1, String price2, String price3, Model model) {
		final double TAX = 1.08;
		int price01 = Integer.parseInt(price1);
		int price02 = Integer.parseInt(price2);
		int price03 = Integer.parseInt(price3);

		int totalPrice = price01 + price02 + price03;
		String totalPricewithCommma = String.format("%,d", totalPrice);
		int tatalPriceIncludeTax = (int) (totalPrice * TAX);
		String tatalPriceIncludeTaxwithCommma = String.format("%,d", tatalPriceIncludeTax);

		model.addAttribute("totalPrice", totalPricewithCommma);
		model.addAttribute("tatalPriceIncludeTax", tatalPriceIncludeTaxwithCommma);
		;

		return "output";
	}

}
