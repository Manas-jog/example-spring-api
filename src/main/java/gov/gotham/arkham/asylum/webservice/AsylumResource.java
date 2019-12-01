package gov.gotham.arkham.asylum.webservice;

import gov.gotham.arkham.asylum.dto.request.PatientRequest;
import gov.gotham.arkham.asylum.dto.request.RecordRequest;
import gov.gotham.arkham.asylum.dto.request.WardRequest;
import gov.gotham.arkham.asylum.dto.response.PatientResponse;
import gov.gotham.arkham.asylum.dto.response.RecordResponse;
import gov.gotham.arkham.asylum.dto.response.WardResponse;
import gov.gotham.arkham.asylum.service.PatientService;
import gov.gotham.arkham.asylum.service.RecordService;
import gov.gotham.arkham.asylum.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/1.0", produces = MediaType.APPLICATION_JSON_VALUE)
public class AsylumResource {

    @Autowired
    private PatientService patientService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private WardService wardService;


    ///////////////////////////////////////////////////////////////////////////
    /// Patient endpoints
    ///////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/patients", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PatientResponse createPatient(@Valid @RequestBody PatientRequest patientRequest) {
        return patientService.createPatient(patientRequest);
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<PatientResponse> getPatients() {
        return patientService.getPatients();
    }

    @RequestMapping(value = "/patients/{patient_id}", method = RequestMethod.GET)
    public PatientResponse getPatientByID(@PathVariable("patient_id") String id) {
        return patientService.getPatientByID(id);
    }

    @RequestMapping(value = "/patients/{patient_id}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PatientResponse updatePatientByID(@PathVariable("patient_id") String id,
                                             @Valid @RequestBody PatientRequest request) {
        return patientService.updatePatientbyID(id, request);
    }

    @RequestMapping(value = "/patients/{patient_id}", method = RequestMethod.DELETE)
    public void deletePatientByID(@PathVariable("patient_id") String id) {
        patientService.deletePatientByID(id);
    }


    ///////////////////////////////////////////////////////////////////////////
    /// Ward endpoints
    ///////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/wards", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public WardResponse createWard(@Valid @RequestBody WardRequest wardRequest) {
        return wardService.createWard(wardRequest);
    }

    @RequestMapping(value = "/wards", method = RequestMethod.GET)
    public List<WardResponse> getAllWards() {
        return wardService.getAllWards();
    }

    @RequestMapping(value = "/wards/{ward_id}", method = RequestMethod.GET)
    public WardResponse getWardByID(@PathVariable("ward_id") String id) {
        return wardService.getWardByID(id);
    }

    @RequestMapping(value = "/wards/{ward_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public WardResponse updateWard(@PathVariable("ward_id") String id,
                                   @Valid @RequestBody WardRequest request) {
        return wardService.updateWardByID(id, request);
    }

    @RequestMapping(value = "/wards/{ward_id}", method = RequestMethod.DELETE)
    public void deleteWard(@PathVariable("ward_id") String id) {
        wardService.deleteWardByID(id);
    }

    ///////////////////////////////////////////////////////////////////////////
    /// Record endpoints
    ///////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/records", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RecordResponse createRecord(@Valid @RequestBody RecordRequest recordRequest) {
        return recordService.createRecord(recordRequest);
    }

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public List<RecordResponse> getAllRecords() {
        return recordService.getAllRecords();
    }

    @RequestMapping(value = "/records/{record_id}", method = RequestMethod.GET)
    public RecordResponse getRecordByID(@PathVariable("record_id") String id) {
        return recordService.getRecordByID(id);
    }

    @RequestMapping(value = "/records/{record_id}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public RecordResponse updateRecordByID(@PathVariable("record_id") String id,
                                           @Valid @RequestBody RecordRequest recordRequest) {
        return recordService.updateRecordByID(id, recordRequest);
    }

    @RequestMapping(value = "/records/{record_id}", method = RequestMethod.DELETE)
    public void deleteRecord(@PathVariable("record_id") String id) {
        recordService.deleteRecordByID(id);
    }



}


