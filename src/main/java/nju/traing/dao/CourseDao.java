package nju.traing.dao;

import nju.traing.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CourseDao extends JpaRepository<Course, Integer> {
    Page<Course> findAllByCourseType(int type, Pageable pageable);

    List<Course> findAllByCourseType(int type);

    List<Course> findAllByCourseTypeAndAndOrgId(int type, int org);

    /**
     * 开始时间在某一范围的某个类型课程
     *
     * @param type
     * @param start
     * @param end
     * @return
     */
    List<Course> findAllByCourseTypeAndStartDateBetween(int type, Date start, Date end);


    /**
     * 开始时间在某个范围的所有课程
     *
     * @param start
     * @param end
     * @return
     */
    List<Course> findAllByStartDateBetween(Date start, Date end);
}
