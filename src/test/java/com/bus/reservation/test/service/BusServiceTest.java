package com.bus.reservation.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bus.reservation.repo.BusRepository;
import com.bus.reservation.service.BusServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BusServiceTest {
	
	@InjectMocks
	BusServiceImpl busService;

	@Mock
	BusRepository busRepo;
	
	ArrayList<String> sources = new ArrayList<>();
	ArrayList<String> destinations = new ArrayList<>();
	
	@BeforeEach
	void setUp() {
		sources.add("Bengaluru");
		sources.add("Chitradurga");
		sources.add("Mysuru");
		sources.add("Davanagere");
		
		destinations.add("Chitradurga");
		destinations.add("Goa");
		destinations.add("Dharwad");
		destinations.add("Bengaluru");
	}
	@Test
	void testFindSources() {
		Mockito.lenient().when(busRepo.loadBusSources()).thenReturn(sources);
		List<String> findSources = busService.findSources();
//		assertThat(findSources).isEqualTo(sources);
		assertEquals(findSources.get(0), "Bengaluru");
	}
	
	@Test
	void testFindDestinations() {
		Mockito.lenient().when(busRepo.loadBusDestinations()).thenReturn(destinations);
		List<String> findDestinations = busService.findDestinations();
//		assertThat(findDestinations).isEqualTo(destinations);
		assertEquals(findDestinations.get(2), "Dharwad");
	}
}
