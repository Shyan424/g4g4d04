package com.shyan.jdbctemplate;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;

import com.shyan.velocity.VelocityUtil;

@Configuration
@Repository
@ImportResource("classpath:sql.xml")	// 可以取得 xml
public class NamedParameterJdbcTemplateExample {

	@Resource(name = "sql")		// 取得xml內id的資料
	private Map<String, String> sqlMap;
	
//	@Autowired
//	private NamedParameterJdbcTemplate namedParamterJdbcTemplate;
	
	
	/**
	 * 使用Velocity可以替換模板變數($xx)
	 * @return
	 */
	public String changeTable(String change) {
		Map<String, Object> param = new HashMap<>();
		param.put("startDate", "aaaa");
		param.put("endDate", "ccc");
		param.put("unit", "ddd");
		param.put("table", change);
		
		return  VelocityUtil.render(sqlMap.get("aaa"), param);
	}
	
	
}
