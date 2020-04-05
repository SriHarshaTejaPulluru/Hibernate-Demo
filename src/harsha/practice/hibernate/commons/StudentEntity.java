package harsha.practice.hibernate.commons;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STUDENT")
public class StudentEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "STUDENT_ID", nullable = false)
	private String student_id;

	@Column(name = "STUDENT_NAME", nullable = false, length = 15)
	private String studentName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_SUBJECT", joinColumns = {
			@JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "SUBJECT_ID") })
	private List<SubjectEntity> subjects;

	public StudentEntity(String studentName, List<SubjectEntity> subjects) {
		this.studentName = studentName;
		this.subjects = subjects;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public List<SubjectEntity> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectEntity> subjects) {
		this.subjects = subjects;
	}

}
