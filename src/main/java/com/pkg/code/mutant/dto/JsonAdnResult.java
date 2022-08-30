package com.pkg.code.mutant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dna"
})
@Generated("jsonschema2pojo")
@Builder
public class JsonAdnResult {

    @JsonProperty("count_mutant_dna")
    private int countMutantDna;

    @JsonProperty("count_human_dna")
    private int countHumanDna;

    @JsonProperty("ratio")
    private float ratio;

}
