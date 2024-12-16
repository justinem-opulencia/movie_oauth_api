package com.exercises.movies;

import com.exercises.movies.service.MovieService;
import com.exercises.movies.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.security.test.context.support.WithMockUser;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class MovieServiceImplTest {
    MovieService service = new MovieServiceImpl();

    @Test
    @WithMockUser("admin")
    public void testGetSecurityPositive(){
        assertNotNull(service.getSecurity());
    }

    @Test
    public void testGetSecurityNegative(){
        assertEquals("null",service.getSecurity());
    }
}