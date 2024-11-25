package com.wipro.model;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerService {
	private Queue<String> serviceRequest;

    public CustomerService() {
        serviceRequest = new LinkedList<>();
    }

    public void addRequest(String request) {
        serviceRequest.add(request);
    }

    public void processRequest() {
        if (!serviceRequest.isEmpty()) {
            System.out.println("Processing: " + serviceRequest.poll());
        } else {
            System.out.println("No pending requests.");
        }
    }

    public void viewPendingRequests() {
        for (String request : serviceRequest) {
            System.out.println(request);
        }
    }

}
