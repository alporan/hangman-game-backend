package com.alporan.hangmangame.apiTmdb.services;

import com.alporan.hangmangame.apiTmdb.model.Genre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenreServiceImplTest {
	
	@Autowired
	GenreService genreService;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testGetGenres() throws Exception {
	
	}
}
