package fi.haagahelia.jobTrackingDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VacancyRepository extends CrudRepository<Vacancy, Long> {

	List<Vacancy> findByTitle(String title);
	
	List<Vacancy> findByLocation(@Param("location") String location);
	List<Vacancy> findByCompany(@Param("company") String company);
	List<Vacancy> findByPostedDate(@Param("postedDate") String postedDate);
	
	

}
