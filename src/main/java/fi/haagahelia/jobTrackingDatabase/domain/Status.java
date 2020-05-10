package fi.haagahelia.jobTrackingDatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long decisionid;
	private String decision;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
	private List<Vacancy> vacancies;

	public Status() {
	}

	public Status(String decision) {
		super();
		this.decision = decision;
	}

	

	public Long getDecisionid() {
		return decisionid;
	}

	public void setDecisionid(Long decisionid) {
		this.decisionid = decisionid;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public List<Vacancy> getVacancies() {
		return vacancies;
	}

	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}

}