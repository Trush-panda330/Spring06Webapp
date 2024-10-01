package uetak.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import uetak.entity.Shain;

/**データベースとのやり取りをするところ
 * 
 * */
@Repository
public class ShainRepositoryImpl implements ShainRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	//全社員の情報をとってくる
	@Override
	public List<Shain> findAll() {
		//SQL文の作成
		final String sql = "select id, name, gender, nen, address from shain";

		//SQLの実行
		List<Shain> shainList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Shain>(Shain.class));

		return shainList;

	}

	@Override
	public Shain findByShainId(int shainId) {

		//SQL文の作成
		final String sql = "select id, name, gender, nen, address from shain where id = :id";

		//パラメーターの作成
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", shainId);
		
		//SQLの実行
		List<Shain> shainList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Shain>(Shain.class));
		
		//リストを判定して戻す
		return shainList.isEmpty() ? null : shainList.get(0);
	}

	@Override
	public void insertShain(Shain shain) {
		//SQL文の作成
		final String sql = "insert into shain(id, name, gender, nen, address)"
				+ "values(:id, :name, :gender, :nen, :address)";

		// パラメーターの作成
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", shain.getId());
		param.addValue("name", shain.getName());
		param.addValue("gender", shain.getGender());
		param.addValue("nen", shain.getNen());
		param.addValue("address", shain.getAddress());

		//SQLの実行
		jdbcTemplate.update(sql, param);

	}

	@Override
	public void updateShain(Shain shain) {
		//SQL文の作成
		

	}

	@Override
	public void deleteShain(Shain shain) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
