package com.Rutuja.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Rutuja.demo.Model.StockDetails;

public interface StockRepository extends CrudRepository<StockDetails, Integer>{

}
