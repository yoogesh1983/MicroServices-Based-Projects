package com.codetutr.vehicleTrackingSystem.repository.Hibernate;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.codetutr.vehicleTrackingSystem.Entity.Profile;

@Repository
public class ProfileRepositoryOldWay 
{
    @PersistenceContext
    private EntityManager entityManager;
    
	public Profile save(Profile profile) throws Exception 
	{
		Profile savedProfile = null;
		try
		{
			entityManager.persist(profile);
			savedProfile = profile;
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return savedProfile;
	}

	
    public Profile getProfileByProfileId(long id) {
        return entityManager.find(Profile.class, id);
    }
    

    @SuppressWarnings("unchecked")
	public Collection<Profile> findAllProfiles() {
    	Query query = entityManager.createQuery("SELECT profile FROM Profile profile");
    	return (Collection<Profile>) query.getResultList();
    }
}
