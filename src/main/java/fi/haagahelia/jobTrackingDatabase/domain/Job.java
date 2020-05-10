package fi.haagahelia.jobTrackingDatabase.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jobid;
	
	
	private String title, company, description;
	
	public Job() {
		
	}
	
	

	public Job(String title, String company, String description) {
		super();
		this.title = title;
		this.company = company;
		this.description = description;
	}



	public Long getJobid() {
		return jobid;
	}



	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}


	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
