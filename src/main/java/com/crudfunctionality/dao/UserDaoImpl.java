package com.crudfunctionality.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.crudfunctionality.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	public List<User> listAllUsers() {
		String sql = "SELECT * FROM users";
		List<User> usersList = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
		
		return usersList;
	}

	private SqlParameterSource getSqlParameterByModel(User user) {

		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(user != null) {
			paramSource.addValue("id", user.getId());
			paramSource.addValue("name", user.getName());
			paramSource.addValue("email", user.getEmail());
			paramSource.addValue("address", user.getAddress());
			paramSource.addValue("country", user.getCountry());
			paramSource.addValue("sex", user.getSex());
		}
		
		return paramSource;
	}

	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setCountry(rs.getString("country"));
			user.setSex(rs.getString("sex"));
			return user;
		}
	}

	public void saveUser(User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		  //String sql = "INSERT INTO users(name, email, address, country, sex) VALUES(:name, :email, :address, :country, :sex)";

		String sql = "INSERT INTO users(NAME, EMAIL, ADDRESS, COUNTRY, SEX ) VALUES ( :name, :email, :address, :country, :sex)";
		//namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder);
		user.setId(keyHolder.getKey().intValue());
		
	}

	public void updateUser(User user) {
		String sql = "UPDATE USERS SET NAME=:name, EMAIL=:email, ADDRESS=:address, COUNTRY=:country, SEX=:sex WHERE id=:id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
	}

	public void deleteUser(int id) {
		String sql = "DELETE FROM USERS WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new User(id)));		
	}

	public User findUserById(int id) {
		String sql = "SELECT * FROM users WHERE id=:id";
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new User(id)), new UserMapper());
	}

}
