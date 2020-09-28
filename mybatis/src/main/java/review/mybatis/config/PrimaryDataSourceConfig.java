package review.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author JenkinsZhang
 * @date 2020/9/28
 */

@Configuration
@MapperScan(basePackages = "review.mybatis.mapper.primary",sqlSessionFactoryRef = "PrimarySqlSessionFactory",sqlSessionTemplateRef = "PrimarySqlSessionTemplate")
public class PrimaryDataSourceConfig {

    @Bean(name = "PrimaryDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("PrimarySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("PrimaryDatasource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/primary/*.xml"));
        return sqlSessionFactoryBean.getObject();

    }

    @Bean("PrimarySqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("PrimarySqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
