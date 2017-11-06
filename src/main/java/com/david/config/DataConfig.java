package com.david.config;

import com.david.domain.BoardVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by David on 2017-08-27.
 */

@Configuration
@MapperScan("com.david.dao")
public class DataConfig {
    @Bean
    public DataSource dataSource() {

        // MySql 연결 프로퍼티 세팅
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/board?autoReconnect=true");
        dataSource.setUsername("root");
        dataSource.setPassword("admin4W#C");

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        // SqlSession 팩토리 설정 (Mybatis 설정)
        sessionFactoryBean.setDataSource(dataSource());

        // 각 엔티티 클래스별로 등록하면 작동함.
        sessionFactoryBean.setTypeAliases(new Class[]{BoardVO.class});
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:repository/mybatis/*.xml"));
        sessionFactoryBean.setConfigLocation(resolver.getResource("classpath:repository/mybatis.config.xml"));
        return sessionFactoryBean.getObject();
    }
}
