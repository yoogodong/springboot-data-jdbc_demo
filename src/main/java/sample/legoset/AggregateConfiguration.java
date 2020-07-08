package sample.legoset;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.lang.Nullable;

import java.sql.Clob;
import java.sql.SQLException;

import static java.util.Arrays.asList;


/**
 * 1。 演示如何自定义类型转化
 * 2。 演示如何通过事件监听器实现自增主键策略，从而不使用 DB 完成自增主键
 */
@Configuration
public class AggregateConfiguration extends AbstractJdbcConfiguration {
	@Override
	public JdbcCustomConversions jdbcCustomConversions() {

		return new JdbcCustomConversions(asList(new Converter<Clob, String>() {
			@Nullable
			@Override
			public String convert(Clob clob) {
				try {
					return Math.toIntExact(clob.length()) == 0 //
							? "" //
							: clob.getSubString(1, Math.toIntExact(clob.length()));
				} catch (SQLException e) {
					throw new IllegalStateException("不能将Clob 转化成 String.", e);
				}
			}
		}));
	}


}
