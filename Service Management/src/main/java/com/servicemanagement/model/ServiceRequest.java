package com.servicemanagement.model;


public class ServiceRequest {
    private int id;
    private String vehicleNumber;
    private String model;
    private String problemDescription;
    private String status;

    // Getters and setters for all fields

    public ServiceRequest(String vehicleNumber2, String model2, String problemDescription2) {
		// TODO Auto-generated constructor stub
    	vehicleNumber=vehicleNumber2;
    	model=model2;
    	problemDescription=problemDescription2;
	}

	public ServiceRequest() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
