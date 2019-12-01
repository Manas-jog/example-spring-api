package gov.gotham.arkham.asylum.service;

import gov.gotham.arkham.asylum.dto.request.WardRequest;
import gov.gotham.arkham.asylum.dto.response.WardResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WardService {

    /**
     * Create a new ward
     * @param wardRequest
     * @return
     */
    WardResponse createWard(WardRequest wardRequest);

    /**
     * Get all wards
     * @return
     */
    List<WardResponse> getAllWards();

    /**
     * Get ward by ID
     * @param id
     * @return
     */
    WardResponse getWardByID(String id);

    /**
     * update ward
     * @param id
     * @param wardRequest
     * @return
     */
    WardResponse updateWardByID(String id, WardRequest wardRequest);

    /**
     * Delete ward
     * @param id
     */
    void deleteWardByID(String id);

}
