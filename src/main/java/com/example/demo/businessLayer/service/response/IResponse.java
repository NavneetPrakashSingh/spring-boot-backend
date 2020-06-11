package com.example.demo.businessLayer.service.response;

import java.io.Serializable;

public interface IResponse extends Serializable {
    public void setStatus(String status);
    public String getStatus();
    public void setResponse(String response);
    public String getResponse();
}
