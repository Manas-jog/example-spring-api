package gov.gotham.arkham.asylum.service.impl;

import gov.gotham.arkham.asylum.dto.request.WardRequest;
import gov.gotham.arkham.asylum.dto.response.WardResponse;
import gov.gotham.arkham.asylum.service.WardService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class WardServiceImpl implements WardService {

    private Map<String, WardResponse> db = new HashMap<>();

    @PostConstruct
    public void init() {
        WardResponse wardResponse = new WardResponse();
        wardResponse.setWardId("w-001");
        wardResponse.setName("Elizabeth");
        wardResponse.setBeds(200);
        wardResponse.setAssignedDisorders(Arrays.asList(
                "Narcissim",
                "Schizoid",
                "Suicidal tendencies"
        ));
        db.put(wardResponse.getWardId(), wardResponse);
    }

    @Override
    public WardResponse createWard(WardRequest wardRequest) {

        WardResponse wardResponse = new WardResponse();
        wardResponse.setWardId(UUID.randomUUID().toString());
        map(wardResponse, wardRequest);
        db.put(wardResponse.getWardId(), wardResponse);

        return wardResponse;

    }

    @Override
    public List<WardResponse> getAllWards() {
        return new LinkedList<>(db.values());
    }

    @Override
    public WardResponse getWardByID(String id) {
        return db.get(id);
    }

    @Override
    public WardResponse updateWardByID(String id, WardRequest wardRequest) {

        if (db.containsKey(id)) {
            WardResponse wardResponse = db.get(id);
            map(wardResponse, wardRequest);
            return wardResponse;
        }
        return null;

    }

    @Override
    public void deleteWardByID(String id) {
        db.remove(id);
    }

    ///////////////////////////////////////////////////////////////////////////
    /// Private methods
    ///////////////////////////////////////////////////////////////////////////

    private void map(WardResponse wardResponse, WardRequest wardRequest) {
        wardResponse.setAssignedDisorders(wardRequest.getAssignedDisorders());
        wardResponse.setBeds(wardRequest.getBeds());
        wardResponse.setName(wardRequest.getName());
    }

}
