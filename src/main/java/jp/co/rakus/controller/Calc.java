package jp.co.rakus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数字を受け取り、計算結果を返すメソッド.
 * 
 * @author wataru.saito
 *
 */
@Controller
@RequestMapping("/Calc")
public class Calc {

	/**
	 * セッションを使うためのフィールド.
	 */
	@Autowired
	private HttpSession session;

	/**
	 * 入力画面を呼び出すメソッド.
	 * 
	 * @return 入力画面
	 */
	@RequestMapping("/index")
	public String index() {

		return "inputvalue";
	}

	/**
	 * 計算をし結果を出力に送るメソッド.
	 * 
	 * @param num1
	 *            計算に使う数字
	 * @param num2
	 *            計算に使う数字
	 * @return 出力画面
	 */
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

	/**
	 * リンクから呼ばれて出力画面２へ移動するメソッド.
	 * 
	 * @return 出力画面2
	 * 
	 */
	@RequestMapping("/output2")
	public String output2() {
		return "outputvalue2";
	}
}
