package review.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import review.mybatis.entity.Role;
import review.mybatis.mapper.primary.TestMapper;

import java.util.List;

/**
 * @author JenkinsZhang
 * @date 2020/9/29
 */
@RestController
public class TestController {

    @Autowired
    public TestMapper testMapper;

    @GetMapping("/test")
    public List<Role> test(){
        return testMapper.getAll();
    }
}
