package nju.traing.dao;

import nju.traing.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrganizationDao extends JpaRepository<Organization, Integer> {
    List<Organization> findAllByCreateTimeBetween(Date start,Date end);
    List<Organization> findAllByCity(int city);
    List<Organization> findAllByProvince(int province);


}
