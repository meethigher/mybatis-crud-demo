package top.meethigher.dto;

import top.meethigher.entity.Major;
import top.meethigher.entity.SchoolState;

import java.util.Date;
import java.util.List;

public class SchoolDto {

    private String schoolId;

    private String schoolName;

    private SchoolState schoolState;

    private Date createTime;

    private List<Major> majorList;

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

    public SchoolState getSchoolState() {
        return schoolState;
    }

    public void setSchoolState(SchoolState schoolState) {
        this.schoolState = schoolState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Major> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<Major> majorList) {
        this.majorList = majorList;
    }
}
