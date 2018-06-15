package nju.traing.dao;

import nju.traing.TraingApplication;
import nju.traing.entity.Organization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TraingApplication.class)
public class OrganizationDaoTest {

    @Autowired
    OrganizationDao organizationDao;

    @Test
    public void testAdd() throws Exception {
        Organization organization = new Organization();
        organization.setCity(1);
        organization.setProvince(1);
        organization.setLocation("江苏省南京市鼓楼区汉口路");
        organizationDao.save(organization);
    }

    @Test
    public void testFind() throws Exception {
        List<Organization> organizations = organizationDao.findAll();
        for (Organization o : organizations) {
            System.out.println(o);
        }
    }
}
