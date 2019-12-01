package gov.gotham.arkham.asylum.dto.response;

import java.util.Date;
import java.util.List;

public class PatientResponse {

    private String patientId;
    private Date dateOfBirth;
    private String lastName;
    private String firstName;
    private Date dateOfAdmission;
    private String diagnosedBy;
    private List<String> disorders;
    private String assignedWardId;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getDiagnosedBy() {
        return diagnosedBy;
    }

    public void setDiagnosedBy(String diagnosedBy) {
        this.diagnosedBy = diagnosedBy;
    }

    public List<String> getDisorders() {
        return disorders;
    }

    public void setDisorders(List<String> disorders) {
        this.disorders = disorders;
    }

    public String getAssignedWardId() {
        return assignedWardId;
    }

    public void setAssignedWardId(String assignedWardId) {
        this.assignedWardId = assignedWardId;
    }

}
