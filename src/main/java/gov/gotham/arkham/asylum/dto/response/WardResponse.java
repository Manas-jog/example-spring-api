package gov.gotham.arkham.asylum.dto.response;

import java.util.List;

public class WardResponse {

    private String wardId;
    private String name;
    private Integer beds;
    private List<String> assignedDisorders;

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public List<String> getAssignedDisorders() {
        return assignedDisorders;
    }

    public void setAssignedDisorders(List<String> assignedDisorders) {
        this.assignedDisorders = assignedDisorders;
    }

}
