package fi.haagahelia.jobTrackingDatabase.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import fi.haagahelia.jobTrackingDatabase.domain.Department;
import fi.haagahelia.jobTrackingDatabase.domain.DepartmentRepository;
import fi.haagahelia.jobTrackingDatabase.domain.Job;
import fi.haagahelia.jobTrackingDatabase.domain.JobRepository;
import fi.haagahelia.jobTrackingDatabase.domain.Status;
import fi.haagahelia.jobTrackingDatabase.domain.StatusRepository;
import fi.haagahelia.jobTrackingDatabase.domain.Vacancy;
import fi.haagahelia.jobTrackingDatabase.domain.VacancyRepository;

@Controller
public class VacancyContoller {

	@Autowired
	private VacancyRepository repository;
	@Autowired
	private DepartmentRepository drepository;

	@Autowired
	private StatusRepository arepository;
	
	@Autowired
	private JobRepository jrepository;

	
	@RequestMapping("/home")
	public String home() {
		return "home";

	}
	/**
	 * Login page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	/**
	 * This is a home page after successfully log in
	 * 
	 * @param model
	 * @return the page list of all vacancies 
	 */

	@RequestMapping("/vacancylist")
	public String vacancyList(Model model) {
		model.addAttribute("vacancies", repository.findAll());
		return "vacancylist";

	}

	
	/**
	 * Return page when add a vacancy to the list 
	 * @param  model
	 * @return a form add
	 */
	
	
	@RequestMapping(value = "/add")
	public String addVacancy(Model model) {
		model.addAttribute("vacancy", new Vacancy());
		model.addAttribute("departments", drepository.findAll());
		model.addAttribute("status", arepository.findAll());
		return "addVacancy";
	}


	
	/**
	 * edit html page for a specific vacancy Id
	 * only for Admin
	 * @param vacancyId
	 * @param model
	 * @return a form to edit
	 */
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editVacancy(@PathVariable("id") Long vacancyId, Model model) {
		model.addAttribute("vacancy", repository.findById(vacancyId));
		model.addAttribute("departments", drepository.findAll());
		model.addAttribute("status", arepository.findAll());
		return "editVacancy";
	}


	
	/**
	 * Return page when submit vacancy
	 * @param vacancy
	 * @return
	 */
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Vacancy vacancy) {
		repository.save(vacancy);
		return "redirect:/vacancylist";
	}


	/**
	 * delete by specific vacancy Id
	 * only for Admin
	 * @param vacancyId
	 * @param model
	 * @return 
	 */
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteVacancy(@PathVariable("id") Long vacancyId, Model model) {
		repository.deleteById(vacancyId);
		return "redirect:/vacancylist";
	}
	

	/**
	 * Jobs page 
	 * 
	 * @param model
	 * @return the page retuns the list of jobs to apply
	 */

	@RequestMapping("/jobs")
	public String jobsList(Model model) {
		model.addAttribute("jobs", jrepository.findAll());
		return "jobs";

	}
	
	/**
	 * delete by specific job Id
	 * only for Admin
	 * @param jobId
	 * @param model
	 * @return 
	 */

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deleteJob/{jobid}", method = RequestMethod.GET)
	public String deleteJob(@PathVariable("jobid") Long jobid, Model model) {
		jrepository.deleteById(jobid);
		return "redirect:/jobs";
	}
	

	/**
	 * Return page when add a addJob to the list 
	 * @param  model
	 * @return a form add
	 */
	
	
	@RequestMapping(value = "/addJob")
	public String addJob(Model model) {
		model.addAttribute("job", new Job());
		return "addJob";
	}
	
	
	/**
	 * Return page when submit job
	 * @param job
	 * @return
	 */
	
	@RequestMapping(value = "/saveJob", method = RequestMethod.POST)
	public String save(Job job) {
		jrepository.save(job);
		return "redirect:/jobs";
	}
	
	
	// RESTful services

	/**
	 * This end point: /vacancy
	 * 
	 * @return a Rest API JSON file with all the vacancies in database
	 */

	@RequestMapping(value = "/vacancies", method = RequestMethod.GET)
	public @ResponseBody List<Vacancy> vacancyListRest() {
		return (List<Vacancy>) repository.findAll();
	}

	/**
	 * This end point: /vacancy
	 * 
	 * @return a Rest API JSON file with a specific id
	 */

	@RequestMapping(value = "/vacancy/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Vacancy> findStudentRest(@PathVariable("id") Long vacancyId) {
		return repository.findById(vacancyId);
	}

	/**
	 * This end point: /departments
	 * 
	 * @return a Rest API JSON file with all departments
	 */

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public @ResponseBody List<Department> departmentListRest() {
		return (List<Department>) drepository.findAll();
	}

	/**
	 * This end point: /decisions
	 * 
	 * @return a Rest API JSON file with all decisions
	 */

	@RequestMapping(value = "/decisions", method = RequestMethod.GET)
	public @ResponseBody List<Status> statusListRest() {
		return (List<Status>) arepository.findAll();
	}


	/**
	 * This end point: /job
	 * 
	 * @return a Rest API JSON file with all the vacancies in database
	 */

	@RequestMapping(value = "/job", method = RequestMethod.GET)
	public @ResponseBody List<Job> jobListRest() {
		return (List<Job>) jrepository.findAll();
	}

	/**
	 * This end point: /job
	 * 
	 * @return a Rest API JSON file with a specific id
	 */

	@RequestMapping(value = "/job/{jobid}", method = RequestMethod.GET)
	public @ResponseBody Optional<Job> findJonsRest(@PathVariable("jobid") Long jobid) {
		return jrepository.findById(jobid);
	}
	

}
