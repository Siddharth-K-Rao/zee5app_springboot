package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, String> {
	
	// Boolean result ===> existsBy word
	// Retrieve details based on name and language ===> findBy word
	
	Boolean existsByName(String name);
	Optional<Movies> findByNameAndLanguage(String name, String language);
	Optional<Movies> findByName(String name);
	Optional<Movies> findByNameAndReleaseDate(String name, String releaseDate);
	Optional<List<Movies>> findByCast(String cast);
	
}
