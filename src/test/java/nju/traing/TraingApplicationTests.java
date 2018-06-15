package nju.traing;

import nju.traing.dao.CourseDao;
import nju.traing.dao.OrganizationDao;
import nju.traing.entity.Course;
import nju.traing.entity.Organization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TraingApplicationTests {
	@Autowired
	private OrganizationDao organizationDao;
	@Autowired
	private CourseDao courseDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void addOrg(){
		Organization organization=new Organization();
		organization.setCity(1);
		organization.setProvince(2);
		organization.setLocation("汉口路22号");
		organizationDao.save(organization);
	}

	@Test
	public void addCourse(){
		Course course=new Course();
		course.setCourseType(1);
		course.setDescription("船新的课程");
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.MONTH,1);
		course.setStartDate(calendar.getTime());
		calendar.add(Calendar.MONTH,1);
		course.setEndDate(calendar.getTime());
		course.setName("软件工程");
		course.setOrgId(1);
		course.setNum(20);
		course.setPrice(30000);
		course.setSold(15);
		course.setUserId(1);
		course.setTeacher("丁ey");
		courseDao.save(course);
	}

}
