package com.exercises.movies;

import com.exercises.movies.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.exercises.movies.service.MovieService;
import com.exercises.movies.repository.MovieRepository;
import org.mockito.Mock;
import org.mockito.InjectMocks;

@SpringBootTest
class MoviesApplicationTests {
	MovieService service = new MovieServiceImpl();

	@Test
	void contextLoads() {
	}
	@Test
	public void testGetSecurity(){
		System.out.println(service.getSecurity());
	}

}
