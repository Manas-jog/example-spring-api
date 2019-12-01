package gov.gotham.arkham.asylum.dto.request;

import java.util.List;

public class WardRequest {

    private String name;
    private Integer beds; //Always use object types for DTO classes as the values can be null in JSON!
    private List<String> assignedDisorders;

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
