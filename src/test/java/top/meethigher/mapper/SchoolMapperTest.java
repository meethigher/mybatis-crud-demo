package top.meethigher.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import top.meethigher.entity.School;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@SpringBootTest
class SchoolMapperTest {

    @Resource
    private SchoolMapper schoolMapper;

    @Test
    void duplicateNameCheck() {
        Set<String> set = schoolMapper.duplicateNameCheck(null, "家里蹲大学");
        Assert.notEmpty(set,"名称不重复");
    }

    @Test
    void findByKeywords() {
        List<School> list = schoolMapper.findByKeywords("大学");
        Assert.notEmpty(list,"未查询到内容");
    }
}