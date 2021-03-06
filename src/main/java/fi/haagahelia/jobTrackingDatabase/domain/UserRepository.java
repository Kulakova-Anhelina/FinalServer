package fi.haagahelia.jobTrackingDatabase.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Visitor, Long> {
	Visitor findByUsername(String username);
}