package org.problem;

import java.util.*;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;

public class MainProblemSolving {
		// Change Path According to your workspace
	 	private static String FILE_PATH = "C:/Users/Istar/Workspace_shortestDistance/short_distance_problem/src/customers.json";
	    private static final double MY_LATITUDE = Math.toRadians(12.935076);
	    private static final double MY_LONGITUDE = Math.toRadians(77.614277);
	    private static final double R = 6371000; //In Meters
	    private static final double DISTANCE_COVER_IN_METERS = 100000.00; //In Meters

	    public static void main(String[] args) {

	        /** Read the file **/
	        List<Customer> customers = readJsonFile();

	        /** Process List **/
	        customers = calculateNearByCustomer(customers, R);

	        /** Print Lines **/
	        listOfCustomerNearBy(customers);

	    }

	    private static List<Customer> calculateNearByCustomer(List<Customer> customers, double r) {
	        List<Customer> filter = new ArrayList<Customer>();

	        for(Customer customer : customers){
	            double deltaLongitude = MY_LONGITUDE - Math.toRadians(customer.getLongitude());
	            double deltaSigma = Math.acos(
	                    Math.sin(MY_LATITUDE)*Math.sin(Math.toRadians(customer.getLatitude())) +
	                    Math.cos(MY_LATITUDE)*Math.cos(Math.toRadians(customer.getLatitude()))*Math.cos(deltaLongitude)
	            );

	            double distance = R * deltaSigma;

	            if(distance <= DISTANCE_COVER_IN_METERS){
	                filter.add(customer);
	            }
	        }
	        return filter;
	    }

	    public static List<Customer> readJsonFile(){
	        try {
	            FileReader reader = new FileReader(FILE_PATH);
	            ObjectMapper mapper = new ObjectMapper();

	            try {
	                return mapper.readValue(reader, mapper.getTypeFactory().constructCollectionType(
	                        List.class, Customer.class));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        return new ArrayList<Customer>();
	    }

	    private static void listOfCustomerNearBy(List<Customer> customers){
	        Collections.sort(customers, new CustomerComparator());

	        System.out.println("******************** List of Customers next near to office ********************");
	        for(Customer customer : customers){
	            System.out.println("User Id -------> "+ customer.getUser_id() + " Customer Name ------> " + customer.getName());
	        }
	    }
	}