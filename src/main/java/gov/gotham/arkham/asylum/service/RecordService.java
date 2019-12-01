package gov.gotham.arkham.asylum.service;

import gov.gotham.arkham.asylum.dto.request.RecordRequest;
import gov.gotham.arkham.asylum.dto.response.RecordResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecordService {

    /**
     * Create a new record
     * @param recordRequest
     * @return
     */
    RecordResponse createRecord(RecordRequest recordRequest);

    /**
     * Get all records
     * @return
     */
    List<RecordResponse> getAllRecords();

    /**
     * Get record by ID
     * @param id
     * @return
     */
    RecordResponse getRecordByID(String id);

    /**
     * Update record by ID
     * @param id
     * @param recordRequest
     * @return
     */
    RecordResponse updateRecordByID(String id, RecordRequest recordRequest);

    /**
     * Delete record by ID
     * @param id
     */
    void deleteRecordByID(String id);

}
