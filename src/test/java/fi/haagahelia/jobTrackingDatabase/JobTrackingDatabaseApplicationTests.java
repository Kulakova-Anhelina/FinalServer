package fi.haagahelia.jobTrackingDatabase;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import fi.haagahelia.jobTrackingDatabase.service.UserDetailServiceImpl;
import fi.haagahelia.jobTrackingDatabase.web.VacancyContoller;


/**
* Testing that the context is in controller
*/
@RunWith(SpringRunner.class)
@SpringBootTest
class JobTrackingDatabaseApplicationTests {

	@Autowired
	private VacancyContoller controller;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(userDetailServiceImpl).isNotNull();
	}
}