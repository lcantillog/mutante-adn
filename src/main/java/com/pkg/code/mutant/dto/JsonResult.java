
package com.pkg.code.mutant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "msg",
    "data"
})
@Generated("jsonschema2pojo")
public class JsonResult {

    @JsonProperty("status")
    private HttpStatus status;
    @JsonProperty("msg")
    private String msg;
  //  @JsonProperty("data")
   // private List<Datum> data = null;


    public JsonResult(HttpStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @JsonProperty("status")
    public HttpStatus getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @JsonProperty("msg")
    public String getMsg() {
        return msg;
    }

    @JsonProperty("msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }
/*
    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }*/

}
