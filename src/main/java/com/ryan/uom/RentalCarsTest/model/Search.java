
package com.ryan.uom.RentalCarsTest.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "VehicleList"
})
public class Search {

    @JsonProperty("VehicleList")
    private List<Vehicle> vehicleList = null;

    @JsonProperty("VehicleList")
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    @JsonProperty("VehicleList")
    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

}
