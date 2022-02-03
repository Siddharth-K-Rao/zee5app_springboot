package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, String> {

	Boolean existsByName(String name);
	Optional<Series> findByNameAndLanguage(String name, String language);
	Optional<Series> findByName(String name);
	Optional<Series> findByNameAndReleaseDate(String name, String releaseDate);
	Optional<List<Series>> findByCast(String cast);
	
}
