package com.feliser.colorTest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.feliser.colorTest.entities.ColorTestDatabaseScoreEntity;
import com.feliser.colorTest.entities.ColorTestDatabaseSumEntity;

public interface ColorTestSumRepository extends CrudRepository<ColorTestDatabaseSumEntity, Integer> {
	List<ColorTestDatabaseSumEntity> findByLeftColorAndRightColor(String leftColor, String rightColor);
}
