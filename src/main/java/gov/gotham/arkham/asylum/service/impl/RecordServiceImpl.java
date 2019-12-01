package gov.gotham.arkham.asylum.service.impl;

import gov.gotham.arkham.asylum.dto.request.RecordRequest;
import gov.gotham.arkham.asylum.dto.response.RecordResponse;
import gov.gotham.arkham.asylum.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class RecordServiceImpl implements RecordService {

    private Map<String, RecordResponse> db = new HashMap<>();


    @PostConstruct
    public void init() {
        RecordResponse recordResponse = new RecordResponse();
        recordResponse.setRecordId("r-001");
        recordResponse.setSuccessful(false);
        recordResponse.setResult("Breakdown");
        recordResponse.setPatientId("p-001");
        recordResponse.setProcedure("Electrocute brain");
        recordResponse.setWardId("w-001");

        db.put(recordResponse.getRecordId(), recordResponse);
    }

    @Override
    public RecordResponse createRecord(RecordRequest recordRequest) {

        RecordResponse recordResponse = new RecordResponse();
        recordResponse.setRecordId(UUID.randomUUID().toString());
        map(recordResponse, recordRequest);
        db.put(recordResponse.getRecordId(), recordResponse);

        return recordResponse;

    }

    @Override
    public List<RecordResponse> getAllRecords() {
        return new LinkedList<>(db.values());
    }

    @Override
    public RecordResponse getRecordByID(String id) {

        if (db.containsKey(id))
            return db.get(id);
        return null;

    }

    @Override
    public RecordResponse updateRecordByID(String id, RecordRequest recordRequest) {

        if (db.containsKey(id)) {
            RecordResponse recordResponse = db.get(id);
            map(recordResponse, recordRequest);
            return recordResponse;
        }

        return null;

    }

    @Override
    public void deleteRecordByID(String id) {
        db.remove(id);
    }


    ///////////////////////////////////////////////////////////////////////////
    /// Private methods
    ///////////////////////////////////////////////////////////////////////////

    private void map(RecordResponse recordResponse, RecordRequest recordRequest) {
        recordResponse.setPatientId(recordRequest.getPatientId());
        recordResponse.setProcedure(recordRequest.getProcedure());
        recordResponse.setResult(recordRequest.getResult());
        recordResponse.setSuccessful(recordRequest.getSuccessful());
        recordRequest.setWardId(recordRequest.getWardId());
    }

}
