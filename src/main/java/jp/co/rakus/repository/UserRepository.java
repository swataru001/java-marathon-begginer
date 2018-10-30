package jp.co.rakus.repository;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.domain.User;

/**
 *　usersテーブルを操作するリポジトリ.
 *
 * @author wataru.saito
 *
 */
@Repository
@Transactional
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 取り出した値をUserドメインに格納するもの.
	 */
	private final static RowMapper<User> USER_ROWMAPPER = (rs, i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		user.setAddress(rs.getString("address"));
		return user;
	};

	/**
	 * idの値をもとに、テーブルからユーザー情報一列持ってくるメソッド.
	 * 
	 * @param id 主キー
	 * @return　ユーザ情報
	 * @throws 存在しない場合は例外が発生
	 */
	public User load(Integer id) {
		String sql = "SELECT id , name, age, address FROM info where id = :id;";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		User user = template.queryForObject(sql, param, USER_ROWMAPPER);
		return user;
	}
}
