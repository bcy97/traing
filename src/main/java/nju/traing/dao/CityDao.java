package nju.traing.dao;

import nju.traing.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityDao extends JpaRepository<City, Integer> {
    List<City> findAllByProvince(int province);
    City findByCity(String city);
    City findById(int id);
}
