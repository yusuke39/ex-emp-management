package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Admin;
import jp.co.sample.form.AdminForm;
import jp.co.sample.service.AdminService;

/**
 * 管理者用のコントローラー.
 * 
 * @author hiranoyuusuke
 *
 */
@Controller
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	
	/**
	 * 管理者登録画面の表示
	 * 
	 * @return 管理者登録画面を表示する
	 */
	@RequestMapping("/")
	public String index() {
		return "administrator/insert";
	}
	
	
	/**
	 * 管理者をDBへINSERTする.
	 * 
	 * @param form　管理者の登録内容
	 * @return 管理者ログイン画面を表示
	 */
	@RequestMapping("/registerAdmin")
	public String registerAdmin(AdminForm form) {
		Admin admin = new Admin();
		admin.setName(form.getName());
		admin.setMailAddress(form.getMailAddress());
		admin.setPassword(form.getPassword());
		System.out.println(admin);
		service.registerAdmin(admin);
		return "administrator/login";
	}

}
