package com.feliser.colorTest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.feliser.colorTest.models.ColorTestDatabaseModel;

public interface ColorTestRepository extends CrudRepository<ColorTestDatabaseModel, Integer> {}