package top.meethigher.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import top.meethigher.entity.School;
import top.meethigher.entity.SchoolState;
import top.meethigher.service.SchoolService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author chenchuancheng github.com/meethigher
 * @see [JUnit 5单元测试保证执行顺序_Mirage__的博客-CSDN博客](https://blog.csdn.net/mirage__/article/details/115747004)
 * @since 2022/9/13 22:59
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SchoolServiceImplTest {

    @Resource
    private SchoolService schoolService;

    private static final School school = mockSchool();

    private static School mockSchool() {
        School school = new School();
        school.setSchoolName("家里蹲大学");
        school.setSchoolState(SchoolState.DISABLE);
        school.setCreateTime(new Date());
        return school;
    }

    @Order(1)
    @Test
    void addSchool() {
        schoolService.addSchool(school);
    }

    @Order(2)
    @Test
    void updateSchool() {
        schoolService.updateSchool(school);
    }


    @Order(3)
    @Test
    void search() {
        List<School> search = schoolService.search("%里蹲%");
        Assert.notEmpty(search, "不可为空");
        Assert.isTrue(SchoolState.DISABLE.equals(search.get(0).getSchoolState()),"");
        search = schoolService.search("%里蹲大学%");
        Assert.notEmpty(search, "不可为空");

    }

    @Order(4)
    @Test
    void deleteSchool() {
        schoolService.deleteSchool(school.getSchoolId());
    }
}

