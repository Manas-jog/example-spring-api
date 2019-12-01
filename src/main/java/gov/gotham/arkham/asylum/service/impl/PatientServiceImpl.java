package gov.gotham.arkham.asylum.service.impl;

import gov.gotham.arkham.asylum.dto.request.PatientRequest;
import gov.gotham.arkham.asylum.dto.response.PatientResponse;
import gov.gotham.arkham.asylum.service.PatientService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {

    /*
        For the first part, we will use in memory object to store examples
        that demonstrate the REST API capability. In the next part, we will
        see how we can persist these records in the database, and also perform validation
     */
    private Map<String, PatientResponse> db;

    //This function will run during instantiation, but before the application starts
    @PostConstruct
    public void init() {
        db = new HashMap<>();

        PatientResponse samplePatientResponse = new PatientResponse();
        samplePatientResponse.setPatientId("p-001");
        samplePatientResponse.setFirstName("Arthur");
        samplePatientResponse.setLastName("Fleck");
        samplePatientResponse.setDateOfAdmission(new Date());
        samplePatientResponse.setAssignedWardId("w-001");
        samplePatientResponse.setDateOfBirth(new Date());
        samplePatientResponse.setDiagnosedBy("Debra Kane");
        samplePatientResponse.setDisorders(
                Arrays.asList(
                        "Pseudobulbar effect",
                        "RCBD",
                        "Schizoid",
                        "Narcissim"));
        db.put(samplePatientResponse.getPatientId(), samplePatientResponse);
    }


    @Override
    public PatientResponse createPatient(PatientRequest patientRequest) {

        PatientResponse newResponse = new PatientResponse();
        newResponse.setPatientId(UUID.randomUUID().toString()); //create new ID using Java's UUID class.
        map(newResponse, patientRequest); //map request data into response
        db.put(newResponse.getPatientId(), newResponse); //add this new record into our in memory database

        return newResponse;

    }

    @Override
    public List<PatientResponse> getPatients() {
        return new LinkedList<>(db.values());
    }

    @Override
    public PatientResponse getPatientByID(String id) {
        if (db.containsKey(id))
            return db.get(id);
        else
            return null; //we should be returning 404 here, but that will be covered in later parts
    }

    @Override
    public PatientResponse updatePatientbyID(String id, PatientRequest request) {

        if (db.get(id) == null)
            return null; //we should be returning 404 here too!

        PatientResponse response = db.get(id);
        map(response, request);
        return response;

    }

    @Override
    public void deletePatientByID(String id) {
        db.remove(id);
    }


    ///////////////////////////////////////////////////////////////////////////
    /// Private methods
    ///////////////////////////////////////////////////////////////////////////

    private void map(PatientResponse response, PatientRequest request) {
        response.setFirstName(request.getFirstName());
        response.setLastName(request.getLastName());
        response.setDateOfBirth(request.getDateOfBirth());
        response.setDateOfAdmission(request.getDateOfAdmission());
        response.setDiagnosedBy(request.getDiagnosedBy());
        response.setDisorders(request.getDisorders());
        response.setAssignedWardId(request.getAssignedWardId());
    }

}
