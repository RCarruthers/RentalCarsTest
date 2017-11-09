
package com.ryan.uom.RentalCarsTest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Search"
})
public class VehicleList {

    @JsonProperty("Search")
    private Search search;

    @JsonProperty("Search")
    public Search getSearch() {
        return search;
    }

    @JsonProperty("Search")
    public void setSearch(Search search) {
        this.search = search;
    }

}
