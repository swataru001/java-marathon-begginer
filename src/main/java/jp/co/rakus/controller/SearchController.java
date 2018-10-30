package jp.co.rakus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.User;
import jp.co.rakus.form.UserForm;
import jp.co.rakus.service.SearchService;

/**
 * 入力された数字（ID）をもとにデータベースから適切な列を取り出すコントローラー
 * @author wataru.saito
 *
 */
@Controller
@RequestMapping("/seach")
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	/**
	 * 入力された値をUserFormオブジェクトに格納するためのオブジェクト生成.
	 * @return
	 */
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	/**
	 * 入力画面を呼び出すメソッド.
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "userinfosearch";
	}
	
	/**
	 * 	入力された数字をもとにデータベースから列を取り出し、ドメインにデータを格納するためのメソッド
	 * @param id　入力値
	 * @param model　リクエストパラメーター
	 * @return　出力画面
	 */
	@RequestMapping("/create")
	public String create(UserForm userForm ,Model model) {
		int valueOfId = userForm.getId();
		User user = new User();
		user = searchService.load(valueOfId);
		model.addAttribute("user", user);
		return "userinfoview";
	}
}
