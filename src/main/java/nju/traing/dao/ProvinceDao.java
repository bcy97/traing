package nju.traing.dao;

import nju.traing.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceDao extends JpaRepository<Province,Integer> {
    Province findByProvince(String province);
}
