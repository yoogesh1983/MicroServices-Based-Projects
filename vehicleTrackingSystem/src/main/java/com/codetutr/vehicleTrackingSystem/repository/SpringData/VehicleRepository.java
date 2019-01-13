package com.codetutr.vehicleTrackingSystem.repository.SpringData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetutr.vehicleTrackingSystem.Entity.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle, Long>
{
	public List<Vehicle> findByname(String name);
} 
