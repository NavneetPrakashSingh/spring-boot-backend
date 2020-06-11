package com.example.demo.businessLayer.service.response;


public class JwtResponse implements IResponse {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }

    @Override
    public void setStatus(String status) {

    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public void setResponse(String response) {

    }

    @Override
    public String getResponse() {
        return this.jwttoken;
    }
}