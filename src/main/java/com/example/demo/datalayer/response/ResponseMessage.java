package com.example.demo.datalayer.response;

public class ResponseMessage implements IResponse {
    String status;
    String response;

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String getResponse() {
        return this.response;
    }
}
