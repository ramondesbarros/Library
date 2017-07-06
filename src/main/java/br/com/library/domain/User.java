package br.com.library.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -06072017001L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long idUser;

    private String nameUser;
    private String registrationNumberUser;
    private Course courseUser;
    private CoursePeriod studyPeriodUser;

    @OneToMany(mappedBy = "user")
    private Set<Loan> loan;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getRegistrationNumberUser() {
        return registrationNumberUser;
    }

    public void setRegistrationNumberUser(String registrationNumberUser) {
        this.registrationNumberUser = registrationNumberUser;
    }

    public Course getCourseUser() {
        return courseUser;
    }

    public void setCourseUser(Course courseUser) {
        this.courseUser = courseUser;
    }

    public CoursePeriod getStudyPeriodUser() {
        return studyPeriodUser;
    }

    public void setStudyPeriodUser(CoursePeriod studyPeriodUser) {
        this.studyPeriodUser = studyPeriodUser;
    }

    public Set<Loan> getLoan() {
        return loan;
    }

    public void setLoan(Set<Loan> loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "User [idUser=" + idUser + ", nameUser=" + nameUser + ", registrationNumberUser="
                + registrationNumberUser + ", courseUser=" + courseUser + ", studyPeriodUser=" + studyPeriodUser
                + ", loan=" + loan + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((courseUser == null) ? 0 : courseUser.hashCode());
        result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
        result = prime * result + ((loan == null) ? 0 : loan.hashCode());
        result = prime * result + ((nameUser == null) ? 0 : nameUser.hashCode());
        result = prime * result + ((registrationNumberUser == null) ? 0 : registrationNumberUser.hashCode());
        result = prime * result + ((studyPeriodUser == null) ? 0 : studyPeriodUser.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (courseUser != other.courseUser)
            return false;
        if (idUser == null) {
            if (other.idUser != null)
                return false;
        } else if (!idUser.equals(other.idUser))
            return false;
        if (loan == null) {
            if (other.loan != null)
                return false;
        } else if (!loan.equals(other.loan))
            return false;
        if (nameUser == null) {
            if (other.nameUser != null)
                return false;
        } else if (!nameUser.equals(other.nameUser))
            return false;
        if (registrationNumberUser == null) {
            if (other.registrationNumberUser != null)
                return false;
        } else if (!registrationNumberUser.equals(other.registrationNumberUser))
            return false;
        if (studyPeriodUser != other.studyPeriodUser)
            return false;
        return true;
    }
}
