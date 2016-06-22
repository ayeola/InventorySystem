/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.response;

/**
 *
 * @author ayeola
 */
public class ServiceResponse {
    private String statusCode;
    private String statusMessage;
    private String sessionId;

    public ServiceResponse() {
    }

    public ServiceResponse(String statusCode, String statusMessage, String sessionId) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.sessionId = sessionId;
    }

    

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    
}
