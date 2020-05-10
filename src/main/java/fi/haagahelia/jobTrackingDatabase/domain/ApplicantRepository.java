package fi.haagahelia.jobTrackingDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Status, Long > {
	
	
	 List<Status> findByDecision(String decision);
	

}
