package fi.haagahelia.jobTrackingDatabase.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface JobRepository extends CrudRepository<Job, Long> {
	List<Job> findByTitle(String title);

}
