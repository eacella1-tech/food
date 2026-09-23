package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.FoodsDTO;

@Repository
public class FoodsDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	
	
	public int insert(FoodsDTO dto) {
		String sql = "insert into foods set (seq, foodname, price, stock, category, expiry_date) values(foods_seq.nextval, ?, ?, ?, ?, ?)"; 
		return jdbc.update(sql, dto.getFoodname(), dto.getPrice(), dto.getStock(), dto.getCategory(), dto.getExpiry_date()); 
	}
	
	public List<FoodsDTO> selectAll() {
		String sql = "select * from foods";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(FoodsDTO.class));
	}
	
	public int update(FoodsDTO dto) {
		String sql = "update foods set foodname = ?, price = ?, stock = ?, category = ?, expiry_date = ? where seq = ?";
		return jdbc.update(sql, dto.getFoodname(), dto.getPrice(), dto.getStock(), dto.getCategory(), dto.getExpiry_date(), dto.getSeq());
	}
	
	public int delete(int seq) {
		String sql = "delete from foods where seq = ?";
		return jdbc.update(sql, seq);
	}
}
