package top.meethigher.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import top.meethigher.dto.SchoolDto;
import top.meethigher.entity.Major;
import top.meethigher.entity.School;
import top.meethigher.entity.SchoolState;

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

    /**
     * 分页查询
     *
     * @param rowBounds   分页参数
     * @param schoolName  名称，like
     * @param schoolState 状态，equals
     * @return 集合
     */
    @Select({
            "<script>",
            "select * from school ",
            "<where>",
            "<if test=\"schoolName!=null\">",
            "and school_name like '%'||#{schoolName}||'%'",
            "</if>",
            "<if test=\"schoolName!=null\">",
            "and school_name like '%'||#{schoolName}||'%'",
            "</if>",
            "<if test=\"schoolState!=null\">",
            "and school_state = #{schoolState.code}",
            "</if>",
            "</where>",
            "order by create_time desc",
            "</script>"
    })
    List<School> selectByPage(@Param("rowBounds") RowBounds rowBounds,
                              @Param("schoolName") String schoolName,
                              @Param("schoolState") SchoolState schoolState);


    /**
     * 查询详情
     *
     * @return 详情
     */
    @Select({
            "select school_id,school_name,school_state,create_time from school ",
            "where school_id = #{schoolId}"
    })
    @Results({
            @Result(column = "school_id", property = "schoolId"),
            @Result(column = "school_id", property = "majorList", many = @Many(select = "top.meethigher.mapper.SchoolMapper.selectMajorBySchoolId"))
    })
    SchoolDto selectSchoolBySchoolId(@Param("schoolId") String schoolId);


    /**
     * @param schoolId
     * @return
     */
    @Select("select * from major where school_id = #{schoolId}")
    List<Major> selectMajorBySchoolId(@Param("schoolId") String schoolId);
}
