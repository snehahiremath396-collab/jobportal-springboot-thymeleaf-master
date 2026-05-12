package com.jsp.job_portal;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jsp.job_portal.dto.Job;
import com.jsp.job_portal.dto.Recruiter;
import com.jsp.job_portal.repository.JobRepository;
import com.jsp.job_portal.repository.RecruiterRepository;

@SpringBootApplication
public class JobPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobPortalApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(JobRepository jobRepository, RecruiterRepository recruiterRepository) {
		return args -> {
			if (jobRepository.count() == 0) {
				Recruiter recruiter = new Recruiter();
				recruiter.setName("Dummy Recruiter");
				recruiter.setEmail("dummy@hire.com");
				recruiter.setMobile(9000000000L);
				recruiter.setCompanyName("HireNest Technologies");
				recruiter.setVerified(true);
				recruiterRepository.save(recruiter);

				Job j1 = new Job();
				j1.setRole("Software Engineer");
				j1.setDescription("Develop and maintain Java/Spring Boot applications.");
				j1.setSkills("Java, Spring Boot, SQL");
				j1.setLocation("Bengaluru");
				j1.setCtc(1200000);
				j1.setExperience(2);
				j1.setApproved(true);
				j1.setRecruiter(recruiter);

				Job j2 = new Job();
				j2.setRole("Frontend Developer");
				j2.setDescription("Build responsive user interfaces using HTML, CSS, and JavaScript.");
				j2.setSkills("HTML, CSS, JavaScript, React");
				j2.setLocation("Hyderabad");
				j2.setCtc(1000000);
				j2.setExperience(1);
				j2.setApproved(true);
				j2.setRecruiter(recruiter);

				Job j3 = new Job();
				j3.setRole("Data Analyst");
				j3.setDescription("Analyze datasets and create business reports.");
				j3.setSkills("SQL, Excel, Power BI");
				j3.setLocation("Pune");
				j3.setCtc(900000);
				j3.setExperience(1);
				j3.setApproved(true);
				j3.setRecruiter(recruiter);

				jobRepository.saveAll(List.of(j1, j2, j3));
			}
		};
	}

}
