package top.meethigher.entity;

import java.util.Date;

/**
 * 专业
 *
 * @author chenchuancheng
 * @since 2022/9/13 15:39
 */
public class Major {

    private String schoolId;

    private String majorId;

    private String majorName;

    private Date createTime;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
