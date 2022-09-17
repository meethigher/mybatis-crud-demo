package top.meethigher.service;

import top.meethigher.entity.School;

import java.util.List;

/**
 * 学校
 *
 * @author chenchuancheng
 * @since 2022/9/13 16:51
 */
public interface SchoolService {

    void addSchool(School school);

    void updateSchool(School school);

    void deleteSchool(String schoolId);

    List<School> search(String keywords);


}
