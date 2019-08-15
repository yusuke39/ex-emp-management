package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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
	
	private static final RowMapper<Admin> ADMIN_ROW_MAPPER = (rs,i) -> {
		Admin admin = new Admin();
		admin.setName(rs.getString("name"));
		admin.setMailAddress(rs.getString("mail_address"));
		admin.setPassword(rs.getString("password"));
		return admin;
	};
	
	

	/**
	 * 管理者を登録するメソッド.
	 * 
	 * @param admin
	 */
	public void insert(Admin admin) {
		String sql = "INSERT INTO administrators(name, mail_address, password) VALUES(:name, :mailAddress,:password);";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", admin.getName()).addValue("mailAddress", admin.getMailAddress()).addValue("password", admin.getPassword());
		
		template.update(sql, param);
	}
	
	/**
	 * 管理者がログインする時にメールアドレスとパスワードを検索する.
	 * 
	 * @param admin
	 * @return 管理者情報を返す
	 */
	public Admin load(Admin admin) {
		String sql = "SELECT name,mail_address,password FROM administrators WHERE mail_address = :mailAddress AND password = :password";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", admin.getMailAddress()).addValue("password", admin.getPassword());
		
		Admin loginAdmin = template.queryForObject(sql, param, ADMIN_ROW_MAPPER);
		
		return loginAdmin;
	}
	
}
