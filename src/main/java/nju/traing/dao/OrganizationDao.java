package nju.traing.dao;

import nju.traing.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationDao extends JpaRepository<Organization, Integer> {
}
