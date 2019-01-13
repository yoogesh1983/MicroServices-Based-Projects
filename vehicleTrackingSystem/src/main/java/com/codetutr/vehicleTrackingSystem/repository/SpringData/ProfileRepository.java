package com.codetutr.vehicleTrackingSystem.repository.SpringData;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetutr.vehicleTrackingSystem.Entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	public Profile findByusername(String username);
}
