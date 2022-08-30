
package com.pkg.code.mutant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dna"
})
@Generated("jsonschema2pojo")
public class JsonDNA extends Throwable {

    @JsonProperty("dna")
    private List<String> dna = null;

    @JsonProperty("dna")
    public List<String> getDna() {
        return dna;
    }

    @JsonProperty("dna")
    public void setDna(List<String> dna) {
        this.dna = dna;
    }

}
