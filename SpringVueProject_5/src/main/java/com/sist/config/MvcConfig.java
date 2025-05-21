package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.openqa.selenium.Platform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.protobuf.Internal;
// XML 대신 사용
/*
 * <aop:aspectj-autoproxy/>
 * <context:component-scan base-package="com.sist.*"/>
 * <bean id="viewResolver"
	 	class="org.springframework.web.servlet.view.InternalResourceViewResolver"
	 	p:prefix="/"
	 	p:suffix=".jsp"
   />
 */
@Configuration // 자동 메모리 할당
@EnableAspectJAutoProxy // aop
@ComponentScan(basePackages = {"com.sist.*"}) // context:component-scan
/*
 * <mybatis-spring:scan base-package="com.sist.mapper"
	 	factory-ref="ssf"/>
 */
@MapperScan(basePackages = {"com.sist.mapper"})
//<tx:annotation-driven/>
@EnableTransactionManagement
@EnableWebMvc
// xml / java => xml+java 혼합 사용? 요즘은 혼합 사용 많이 함(xml이 긴 경우가 많음)
public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// HandlerMapping
		configurer.enable();
	}
	@Bean("viewResolver") // bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		return ir;
	}
	/*
	 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="#{db['driver']}"
		p:url="#{db['url']}"
		p:username="#{db['username']}"
		p:password="#{db['password']}"
	/>
	 <tx:annotation-driven/>
	<!-- MyBatis로 전송: SqlSessionFactoryBean -->
	<bean id="ssf"
		class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
	/>
	 */
	// BasicDataSource
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	// SqlSessionFactory
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject(); // sqlSession 보내기
	}
	// Transaction
	/*
	 * <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
	 	   p:dataSource-ref="ds"/>
	 */
	@Bean("transactionManager")
	public PlatformTransactionManager transactionManager()
	{
		DataSourceTransactionManager tx=new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		return tx;
	}
	// Mapper 구현
	
}
