package nju.traing.Service.Impl;

import nju.traing.Service.CourseService;
import nju.traing.dao.CourseDao;
import nju.traing.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public void addCourse(Date startDate, Date endDate, int org, int num, int sold, double price,
                          String name, String description, String teacher, int courseType) {
        Course course=new Course();
        course.setStartDate(startDate);
        course.setEndDate(endDate);
        course.setOrgId(org);
        course.setNum(num);
        course.setSold(sold);
        course.setCourseType(courseType);
        course.setTeacher(teacher);
        course.setPrice(price);
        course.setDescription(description);
        course.setName(name);
        courseDao.save(course);
    }
}
