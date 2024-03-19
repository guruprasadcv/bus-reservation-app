package com.bus.reservation.repo;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bus.reservation.entity.BusEntity;

public interface BusRepository extends JpaRepository<BusEntity, String> {

	@Query("select DISTINCT b.source from BusEntity b")
	List<String> loadBusSources();

	@Query("select DISTINCT b.destination from BusEntity b")
	List<String> loadBusDestinations();

	@Query("select b from BusEntity b where b.source=:source and b.destination=:destination and b.availableDate=:journeyDate")
	List<BusEntity> searchBuses(@Param("source") String source, @Param("destination") String destination,
			@Param("journeyDate") Calendar journeyDate);
	
	BusEntity findBybusId(String busId);

}
