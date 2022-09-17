package top.meethigher.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.meethigher.entity.School;

import java.util.List;
import java.util.Set;

/**
 * School数据访问层
 *
 * @author chenchuancheng
 * @since 2022/9/13 15:51
 */
@Mapper
@Repository
public interface SchoolMapper extends BaseMapper<School> {

    /**
     * 重复名称校验
     *
     * @param schoolId   学校编号
     * @param schoolName 学校名称
     * @return 名称相同的学校编号
     */
    @Select("select school_id from school where school_name=#{schoolName} and school_id <> coalesce (#{schoolId},'')")
    Set<String> duplicateNameCheck(@Param("schoolId") String schoolId, @Param("schoolName") String schoolName);

    /**
     * 通过关键字查询
     * 普通数据库连接符可以使用CONCAT('%',#{keywords},'%')
     * sqlite数据库连接要使用'%'||#{keywords}||'%'
     *
     * @param keywords 关键字
     * @return 符合条件对象
     */
    @Select("select school_id,school_name,school_state,create_time from school " +
            "where school_name like '%'||#{keywords}||'%' or school_id = #{keywords}")
    List<School> findByKeywords(@Param("keywords") String keywords);
}
