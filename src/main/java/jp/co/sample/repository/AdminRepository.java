package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Admin;

/**
 * 管理者のデーターベースにアクセスするrepository.
 * 
 * @author hiranoyuusuke
 *
 */
@Repository
public class AdminRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 管理者を登録するメソッド.
	 * 
	 * @param admin
	 */
	public void insert(Admin admin) {
		String sql = "INSERT INTO administrators(name, mail_address, password) VALUES(name = :name, mail_address = :mailAdderess, password = :password)";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", admin).addValue("mailAddress", admin).addValue("password", admin);
		
		template.update(sql, param);
		
	}
	
}
