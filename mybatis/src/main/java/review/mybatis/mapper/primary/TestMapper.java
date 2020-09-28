package review.mybatis.mapper.primary;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import review.mybatis.entity.Role;

import java.util.List;

/**
 * @author JenkinsZhang
 * @date 2020/9/28
 */
@Mapper
@Component
public interface TestMapper {

    public List<Role>  getAll();
}
