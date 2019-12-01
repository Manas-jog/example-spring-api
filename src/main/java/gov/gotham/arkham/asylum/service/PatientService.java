package gov.gotham.arkham.asylum.service;

import gov.gotham.arkham.asylum.dto.request.PatientRequest;
import gov.gotham.arkham.asylum.dto.response.PatientResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    /**
     * Create a new patient
     * @param patientRequest -> JSON request body will be mapped to this class
     * @return
     */
    PatientResponse createPatient(PatientRequest patientRequest);

    /**
     * Get list of patients
     * @return
     */
    List<PatientResponse> getPatients();

    /**
     * Get patient by ID
     * @param id -> patientID
     * @return
     */
    PatientResponse getPatientByID(String id);

    /**
     * Update patient.
     * @param id -> existing ID
     * @param request
     * @return
     */
    PatientResponse updatePatientbyID(String id, PatientRequest request);

    /**
     * Delete patient
     * @param id -> existing ID
     */
    void deletePatientByID(String id);

}

