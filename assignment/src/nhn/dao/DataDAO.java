package nhn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import nhn.service.NewArticleCommand;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
@Resource
public class DataDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public DataSource getDataSource(){
		return dataSource;
	}                  

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		// datasource를 가지고 JdbcTemplate를 생성한다.
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// insert 수행

//	public int add(Emp emp){
//
//		String sql = "insert into emp(name,title,email,phone) values(?, ?, ?, ?)";
//
//		// 입력 받은 emp객체를 update 실행 인자로 사용하기 위해 Object[]로 변경.
//
//		Object[] args = {emp.getName(),emp.getTitle(),emp.getEmail(),emp.getPhone()};
//
//		return jdbcTemplate.update(sql,args);
//
//	}

	 

	// 전체 데이터 조회

	public List<NewArticleCommand> searchAll(){

		String sql = "select * from guestbook";

		// RowMapper는 ResultSet의 레코드와 객체를 매핑시키는 역할을 한다.

		RowMapper mapper = new RowMapper(){

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				NewArticleCommand emp = new NewArticleCommand();
				emp.setEmail(rs.getString("email"));
				return emp;
			}
		};

		return jdbcTemplate.query(sql, mapper);

	}
}