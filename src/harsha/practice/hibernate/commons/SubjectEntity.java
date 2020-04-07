package harsha.practice.hibernate.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SUBJECT")
public class SubjectEntity {
	@Id
	@GeneratedValue(generator = "system.uuid")
	@GenericGenerator(name = "system.uuid", strategy = "uuid")
	@Column(name = "SUBJECT_ID", nullable = false)
	private String subjectId;

	@Column(name = "STUDENT_NAME", length = 15)
	private String subjectName;

	public SubjectEntity(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
