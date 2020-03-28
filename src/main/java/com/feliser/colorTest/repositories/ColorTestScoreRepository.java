package com.feliser.colorTest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.feliser.colorTest.entities.ColorTestDatabaseScoreEntity;

public interface ColorTestScoreRepository extends CrudRepository<ColorTestDatabaseScoreEntity, Integer> {
	List<ColorTestDatabaseScoreEntity> findByLeftColorAndRightColorOrderByTimestamp(String leftColor, String rightColor);
}