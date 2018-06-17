package nju.traing.Service;

import java.util.Date;

public interface CourseService {
    void addCourse(Date startDate,Date endDate,int org,int num,int sold,double price,
                   String name,String description,String teacher,int courseType);
}
