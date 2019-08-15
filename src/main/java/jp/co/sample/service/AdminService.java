package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Admin;
import jp.co.sample.repository.AdminRepository;


/**
 * コントローラーからの値を受け取りrepositoryへ渡す.
 * 
 * @author hiranoyuusuke
 *
 */
@Service
@Transactional
public class AdminService {
	
	@Autowired
	private AdminRepository repository;
	
	/**
	 * 管理者を登録する.
	 * 
	 * @param admin
	 */
	public void registerAdmin(Admin admin) {
		repository.insert(admin);
	}

}
