package com.nhn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nhn.service.NewArticleCommand;

public class DataDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public DataSource getDataSource(){
		return dataSource;
	}                  

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// insert data 
	public int add(NewArticleCommand article){


		//insert into guestbook(num,email,password,contents,writedate,modifydate) VALUES(NULL,'hyunsoo@ajou.ac.kr','hyunsoo', 'blade AND soul', SYS_TIMESTAMP, null)
		String sql = "insert into guestbook (num,email,password,contents,writedate,modifydate) values (NULL, '"+article.getEmail()+"' , '"+article.getPassword()+"' , '"+article.getContents()+"' , SYS_TIMESTAMP , null );";
		return jdbcTemplate.update(sql);

	}


	// update modified data
	public int modify(NewArticleCommand article){
		//UPDATE table_name SET column_name = {expr | DEFAULT} [, column_name = {expr |
		String sql = "update guestbook SET contents = '"+article.getContents()+"', modifydate = SYS_TIMESTAMP WHERE num IS "+article.getNum()+";";
		Object[] args = {article.getNum(), article.getEmail(),article.getContents(),article.getPassword(),article.getWritedate(),article.getModifydate()};
		return jdbcTemplate.update(sql,args);
	}



	public NewArticleCommand searchOne(String num){

		String sql = "select * from guestbook WHERE num = "+num;


		System.out.println("num is ! = " + num);
//		RowMapper mapper = new RowMapper(){
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
//				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");				
//				NewArticleCommand article = new NewArticleCommand();
//				System.out.println(rs.getInt("num"));
//				System.out.println(rs.getString("email"));
//				article.setNum(rs.getInt("num"));
//				article.setEmail(rs.getString("email"));
//				article.setPassword(rs.getString("password"));
//				article.setContents(rs.getString("contents"));
//				article.setWritedate(rs.getString("writedate"));
//				article.setModifydate(rs.getString("modifydate"));
//				return article;
//			}
//		};
		NewArticleCommand article = (NewArticleCommand)jdbcTemplate.queryForObject(
				sql, new Object[] { num }, new RowMapper(){
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");				
						NewArticleCommand article = new NewArticleCommand();
						System.out.println(rs.getInt("num"));
						System.out.println(rs.getString("email"));
						article.setNum(rs.getInt("num"));
						article.setEmail(rs.getString("email"));
						article.setPassword(rs.getString("password"));
						article.setContents(rs.getString("contents"));
						article.setWritedate(rs.getString("writedate"));
						article.setModifydate(rs.getString("modifydate"));
						return article;
					}
				});
		return article;
	}

	// Search All data
	public List<NewArticleCommand> searchAll(){

		String sql = "select * from guestbook";
		// RowMapper??? ResultSet??? ???????????? ????????? ??????????????? ????????? ??????.
		RowMapper mapper = new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				NewArticleCommand article = new NewArticleCommand();

				article.setNum(rs.getInt("num"));
				article.setEmail(rs.getString("email"));
				article.setPassword(rs.getString("password"));
				article.setContents(rs.getString("contents"));
				article.setWritedate(rs.getString("writedate"));
				article.setModifydate(rs.getString("modifydate"));
				return article;
			}
		};
		return jdbcTemplate.query(sql, mapper);
	}
}
