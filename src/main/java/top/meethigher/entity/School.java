package top.meethigher.entity;

import com.baomidou.mybatisplus.annotation.OrderBy;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 学校
 * 注解是mybatis-plus提供的
 * [注解 | MyBatis-Plus](https://baomidou.com/pages/223848/#tablename)
 *
 * @author chenchuancheng
 * @since 2022/9/13 15:37
 */
@TableName(value = "school", autoResultMap = true)
public class School {

    @TableId
    private String schoolId;

    private String schoolName;

    private SchoolState schoolState;

    //在执行MybatisPlus的方法selectList(),Page()等非手写查询时自动带上.
    @OrderBy
    private Date createTime;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SchoolState getSchoolState() {
        return schoolState;
    }

    public void setSchoolState(SchoolState schoolState) {
        this.schoolState = schoolState;
    }
}
