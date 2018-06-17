package nju.traing.Service.Impl;

import nju.traing.Service.OrganizationService;
import nju.traing.dao.CityDao;
import nju.traing.dao.OrganizationDao;
import nju.traing.entity.City;
import nju.traing.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private CityDao cityDao;
    @Autowired
    private OrganizationDao organizationDao;
    @Override
    public void addOrg(int city, String location, String name, Date create) {
        Organization organization=new Organization();
        City city1=cityDao.findById(city);
        organization.setCity(city);
        organization.setProvince(city1.getProvince());
        organization.setLocation(location);
        organization.setName(name);
        organization.setCreateTime(create);
        organizationDao.save(organization);
    }
}
