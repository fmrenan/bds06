package com.devsuperior.movieflix.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query("SELECT obj FROM Movie obj WHERE "
			+ "(:genreId IS NULL OR  obj.genre.id = :genreId)")
	Page<Movie> searchByGenre(Long genreId, Pageable pageable);
	
	@Query("SELECT obj from Movie obj JOIN FETCH obj.reviews WHERE "
			+ "obj.id = :id")
	Optional<Movie> findById(Long id);
}
